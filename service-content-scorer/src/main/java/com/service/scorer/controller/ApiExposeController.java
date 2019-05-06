package com.service.scorer.controller;

import com.service.scorer.models.entity.RepoRank;
import com.service.scorer.repository.RepoRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/{repoName}")
    public List<RepoRank> getRepoRanking(@PathVariable String repoName) {
        return repoRankRepository.findTop20ByRepoNameOrderByScoreDesc(repoName);
    }

    @GetMapping(path = "/processed/repos")
    public List<String> getProcessedRepos() {
        return repoRankRepository.findDistinctRepos();
    }

}
