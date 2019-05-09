package com.service.account.controllers;

import com.service.account.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountController {

    private final RestTemplate restTemplate;

    @Autowired
    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/{id}")
    public User getAccount(@PathVariable int id) {
        ResponseEntity<User> response = restTemplate.exchange(
                "https://api.github.com/user/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<User>() {
                });
        return response.getBody();
    }

}
