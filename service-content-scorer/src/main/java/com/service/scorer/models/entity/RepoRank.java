package com.service.scorer.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "REPO_RANK")
@Entity
public class RepoRank implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private int id;

    @Column(name = "REPO_NAME")
    private String repoName;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "SCORE")
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
