package com.service.api.controller;

import com.service.api.models.CodeReview;
import com.service.api.models.CodeReviewComment;
import com.service.api.models.RepoRank;
import com.service.api.models.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/rank/{repoName}")
    public List<RepoRank> getRepoRanking(@PathVariable String repoName) {
        ResponseEntity<List<RepoRank>> response = restTemplate.exchange(
                "http://localhost:8762/scorer/score/api/" + repoName,
                HttpMethod.GET,
                getAuthenticationHeaders(),
                new ParameterizedTypeReference<List<RepoRank>>() {
                });
        return response.getBody();
    }

    @GetMapping(path = "/contributor/{repoName}")
    public List<UserStats> getContributorList(@PathVariable String repoName) {
        ResponseEntity<List<UserStats>> response = restTemplate.exchange(
                "http://localhost:8762/repo/repos/api/" + repoName + "/contributions",
                HttpMethod.GET,
                getAuthenticationHeaders(),
                new ParameterizedTypeReference<List<UserStats>>() {
                });
        return response.getBody();
    }


    @GetMapping(path = "/review/{repoName}")
    public List<CodeReview> getCodeReviewList(@PathVariable String repoName) {
        ResponseEntity<List<CodeReview>> response = restTemplate.exchange(
                "http://localhost:8762/repo/repos/api/" + repoName + "/reviews",
                HttpMethod.GET,
                getAuthenticationHeaders(),
                new ParameterizedTypeReference<List<CodeReview>>() {
                });
        return response.getBody();
    }

    @GetMapping(path = "/comment/{repoName}")
    public List<CodeReviewComment> getCodeReviewCommentList(@PathVariable String repoName) {
        ResponseEntity<List<CodeReviewComment>> response = restTemplate.exchange(
                "http://localhost:8762/repo/repos/api/" + repoName + "/comments",
                HttpMethod.GET,
                getAuthenticationHeaders(),
                new ParameterizedTypeReference<List<CodeReviewComment>>() {
                });
        return response.getBody();
    }

    private String getAuthenticationToken() {
        String username = "admin";
        String password = "12345";
        String requestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        String authUri = "http://localhost:8762/auth/";
        ResponseEntity<String> response = restTemplate.exchange(authUri, HttpMethod.POST, entity, String.class);
        for (Map.Entry<String, List<String>> entry : response.getHeaders().entrySet()) {
            if (entry.getKey().equals("Authorization")) {
                return entry.getValue().get(0);
            }
        }
        return "";
    }

    private HttpEntity getAuthenticationHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAuthenticationToken());
        return new HttpEntity<>("", headers);
    }

}
