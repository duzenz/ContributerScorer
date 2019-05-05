package com.service.api.controller;

import com.service.api.models.CodeReview;
import com.service.api.models.CodeReviewComment;
import com.service.api.models.RepoRank;
import com.service.api.models.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ApiController {

    private final RestTemplate restTemplate;
    //TODO get Base Urls from common

    @Autowired
    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/rank/{repoName}")
    public List<RepoRank> getRepoRanking(@PathVariable String repoName) {
        ResponseEntity<List<RepoRank>> response = restTemplate.exchange(
                "http://localhost:8000/scorer/api/" + repoName,
                HttpMethod.GET,
                getHeaders(),
                new ParameterizedTypeReference<List<RepoRank>>() {
                });
        return response.getBody();
    }

    @GetMapping(path = "/contributor/{repoName}")
    public List<UserStats> getContributorList(@PathVariable String repoName) {
        ResponseEntity<List<UserStats>> response = restTemplate.exchange(
                "http://localhost:8000/repo/api/" + repoName + "/contributions",
                HttpMethod.GET,
                getHeaders(),
                new ParameterizedTypeReference<List<UserStats>>() {
                });
        return response.getBody();
    }

    @GetMapping(path = "/review/{repoName}")
    public List<CodeReview> getCodeReviewList(@PathVariable String repoName) {
        ResponseEntity<List<CodeReview>> response = restTemplate.exchange(
                "http://localhost:8000/repo/api/" + repoName + "/reviews",
                HttpMethod.GET,
                getHeaders(),
                new ParameterizedTypeReference<List<CodeReview>>() {
                });
        return response.getBody();
    }

    @GetMapping(path = "/comment/{repoName}")
    public List<CodeReviewComment> getCodeReviewCommentList(@PathVariable String repoName) {
        ResponseEntity<List<CodeReviewComment>> response = restTemplate.exchange(
                "http://localhost:8000/repo/api/" + repoName + "/comments",
                HttpMethod.GET,
                getHeaders(),
                new ParameterizedTypeReference<List<CodeReviewComment>>() {
                });
        return response.getBody();
    }

    private HttpEntity getHeaders() {
        return null;
    }

}
