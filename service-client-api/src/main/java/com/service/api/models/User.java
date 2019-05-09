package com.service.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String login;
    private int id;
    private String html_url;
    private String name;
    private String location;
    private String email;
    private int public_repos;
    private int followers;
    private int following;

}