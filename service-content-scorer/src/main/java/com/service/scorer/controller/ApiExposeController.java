package com.service.scorer.controller;

import com.service.scorer.models.entity.RepoRank;
import com.service.scorer.repository.RepoRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiExposeController {

    @Autowired
    RepoRankRepository repoRankRepository;

    @Autowired
    RedisTemplate<String, RepoRank> redisTemplate;

    @GetMapping(path = "/{repoName}")
    public List<RepoRank> getRepoRanking(@PathVariable String repoName) {
        List<RepoRank> repoRanks = null;
        final String key = "getRanking_" + repoName;
        final ListOperations<String, RepoRank> operations = redisTemplate.opsForList();
        final boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            repoRanks = operations.range(key, 0, -1);
            return repoRanks;
        }
        repoRanks = repoRankRepository.findTop20ByRepoNameOrderByScoreDesc(repoName);
        if (repoRanks.size() > 0) {
            operations.rightPushAll(key, repoRanks);
        }
        return repoRanks;
    }

    @GetMapping(path = "/processed/repos")
    public List<String> getProcessedRepos() {
        return repoRankRepository.findDistinctRepos();
    }

}
