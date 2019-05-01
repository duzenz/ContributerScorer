package com.eureka.github.controller;

import com.eureka.github.models.entity.CodeReview;
import com.eureka.github.models.entity.CodeReviewComment;
import com.eureka.github.models.entity.UserStats;
import com.eureka.github.repository.CodeReviewCommentRepository;
import com.eureka.github.repository.CodeReviewRepository;
import com.eureka.github.repository.UserStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repos/api")
public class ApiExposeController {

    @Autowired
    UserStatsRepository userStatsRepository;

    @Autowired
    CodeReviewRepository codeReviewRepository;

    @Autowired
    CodeReviewCommentRepository codeReviewCommentRepository;

    @GetMapping(path = "/{repo}/contributions")
    public List<UserStats> getContributions(@PathVariable String repo) {
        return userStatsRepository.findByRepoName(repo);
    }

    @GetMapping(path = "/{repo}/reviews")
    public List<CodeReview> getReviews(@PathVariable String repo) {
        return codeReviewRepository.findByRepoName(repo);
    }

    @GetMapping(path = "/{repo}/comments")
    public List<CodeReviewComment> getComments(@PathVariable String repo) {
        return codeReviewCommentRepository.findByRepoName(repo);
    }

}
