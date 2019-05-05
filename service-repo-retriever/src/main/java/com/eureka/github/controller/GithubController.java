package com.eureka.github.controller;

import com.eureka.github.models.Comment;
import com.eureka.github.models.RepoStatWeek;
import com.eureka.github.models.RepoStatistic;
import com.eureka.github.models.Review;
import com.eureka.github.models.entity.CodeReview;
import com.eureka.github.models.entity.CodeReviewComment;
import com.eureka.github.models.entity.UserStats;
import com.eureka.github.repository.CodeReviewCommentRepository;
import com.eureka.github.repository.CodeReviewRepository;
import com.eureka.github.repository.UserStatsRepository;
import com.service.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GithubController {

    private static String baseUrl = Constant.GITHUB_API_REPO_URL;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserStatsRepository userStatsRepository;

    @Autowired
    CodeReviewRepository codeReviewRepository;

    @Autowired
    CodeReviewCommentRepository codeReviewCommentRepository;

    @PostMapping(path = "/retrieve/{owner}/{repo}")
    public void retrieveRepoStats(@PathVariable String owner, @PathVariable String repo) {
        getRepoContributors(owner, repo);
        getPullRequests(owner, repo);
        getCommentsOfPullRequests(owner, repo);
    }

    private void getRepoContributors(String owner, String repo) {
        String contributorServiceUrl = baseUrl + owner + "/" + repo + "/stats/contributors";
        ResponseEntity<List<RepoStatistic>> response = restTemplate.exchange(
                contributorServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RepoStatistic>>() {
                });

        List<RepoStatistic> repoStatistics = response.getBody();
        if (repoStatistics != null && repoStatistics.size() > 0) {
            for (RepoStatistic repoStatistic : repoStatistics) {
                int authorId = repoStatistic.getAuthor().getId();
                String authorName = repoStatistic.getAuthor().getLogin();
                int addition = 0;
                int deletion = 0;
                int commits = 0;
                System.out.println(authorName);
                for (RepoStatWeek repoStatWeek : repoStatistic.getWeeks()) {
                    addition += repoStatWeek.getA();
                    deletion += repoStatWeek.getD();
                    commits += repoStatWeek.getC();
                }
                saveUserStats(addition, deletion, commits, repo, authorId);
            }
        }
    }

    private void saveUserStats(int addition, int deletion, int commits, String repo, int authorId) {
        UserStats userStats = new UserStats();
        userStats.setAdditionCount(addition);
        userStats.setCommitCount(commits);
        userStats.setDeletionCount(deletion);
        userStats.setRepoName(repo);
        userStats.setUserId(authorId);
        userStatsRepository.save(userStats);
    }

    private void getPullRequests(String owner, String repo) {
        String pullReviewRequestServiceUrl = baseUrl + owner + "/" + repo + "/pulls";
        ResponseEntity<List<Review>> response = restTemplate.exchange(
                pullReviewRequestServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {
                });

        List<Review> reviews = response.getBody();
        if (reviews != null && reviews.size() > 0) {
            for (Review review : reviews) {
                savePullRequest(review, repo);
            }
        }
    }

    private void savePullRequest(Review review, String repo) {
        CodeReview codeReview = new CodeReview();
        codeReview.setRepoName(repo);
        codeReview.setIsMerged(review.getMergedAt() != null ? 1 : 0);
        codeReview.setState(review.getState());
        codeReview.setUrl(review.getUrl());
        codeReview.setReviewId(review.getId());
        if (review.getUser() != null) {
            codeReview.setUserId(review.getUser().getId());
        }
        codeReviewRepository.save(codeReview);
    }

    private void getCommentsOfPullRequests(String owner, String repo) {
        String reviewCommentServiceUrl = baseUrl + owner + "/" + repo + "/comments";
        ResponseEntity<List<Comment>> response = restTemplate.exchange(
                reviewCommentServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Comment>>() {
                });

        List<Comment> comments = response.getBody();
        if (comments != null && comments.size() > 0) {
            for (Comment comment : comments) {
                saveComment(comment, repo);
            }
        }
    }

    private void saveComment(Comment comment, String repo) {
        CodeReviewComment codeReviewComment = new CodeReviewComment();
        codeReviewComment.setRepoName(repo);
        codeReviewComment.setCommentId(comment.getId());
        codeReviewComment.setUrl(comment.getUrl());
        if (comment.getUser() != null) {
            codeReviewComment.setUserId(comment.getUser().getId());
        }
        codeReviewCommentRepository.save(codeReviewComment);
    }

}
