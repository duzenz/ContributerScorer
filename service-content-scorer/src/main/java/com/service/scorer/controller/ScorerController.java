package com.service.scorer.controller;

import com.service.scorer.models.CodeReview;
import com.service.scorer.models.CodeReviewComment;
import com.service.scorer.models.UserStats;
import com.service.scorer.models.entity.RepoRank;
import com.service.scorer.repository.RepoRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ScorerController {

    private final RestTemplate restTemplate;

    private final RepoRankRepository repoRankRepository;

    private Map<Integer, Integer> statMap = new HashMap<>();

    @Autowired
    public ScorerController(RestTemplate restTemplate, RepoRankRepository repoRankRepository) {
        this.restTemplate = restTemplate;
        this.repoRankRepository = repoRankRepository;
    }

    @PostMapping(path = "/{repo}")
    public void scoreRepo(@PathVariable String repo) {
        statMap.clear();

        ResponseEntity<List<UserStats>> response = restTemplate.exchange(
                "http://localhost:8000/repo/api/" + repo + "/contributions",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserStats>>() {
                });
        List<UserStats> userStatsList = response.getBody();

        if (userStatsList != null && userStatsList.size() > 0) {
            for (UserStats userStats : userStatsList) {
                int score = userStats.getAdditionCount() + userStats.getDeletionCount() * 2 + userStats.getCommitCount();
                statMap.put(userStats.getUserId(), score);
            }
        }


        ResponseEntity<List<CodeReview>> response1 = restTemplate.exchange(
                "http://localhost:8000/repo/api/" + repo + "/reviews",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CodeReview>>() {
                });
        List<CodeReview> codeReviewList = response1.getBody();
        if (codeReviewList != null && codeReviewList.size() > 0) {
            for (CodeReview codeReview : codeReviewList) {
                boolean merged = (codeReview.getIsMerged() == 1);
                int score = merged ? 2 : 1;
                int tempScore = statMap.getOrDefault(codeReview.getUserId(), 0);
                int lastScore = score + tempScore;
                statMap.put(codeReview.getUserId(), lastScore);
            }
        }

        ResponseEntity<List<CodeReviewComment>> response2 = restTemplate.exchange(
                "http://localhost:8000/repo/api/" + repo + "/comments",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CodeReviewComment>>() {
                });
        List<CodeReviewComment> codeReviewCommentList = response2.getBody();

        if (codeReviewCommentList != null && codeReviewCommentList.size() > 0) {
            for (CodeReviewComment codeReviewComment : codeReviewCommentList) {
                int tempScore = statMap.getOrDefault(codeReviewComment.getUserId(), 0);
                statMap.put(codeReviewComment.getUserId(), tempScore + 1);
            }
        }
        //TODO first check redis (if scored in some time no need to do it again)

        for (Map.Entry<Integer, Integer> entry : statMap.entrySet()) {
            RepoRank repoRank = new RepoRank();
            repoRank.setUserId(entry.getKey());
            repoRank.setScore(entry.getValue());
            repoRank.setRepoName(repo);
            repoRankRepository.save(repoRank);
        }
    }

}
