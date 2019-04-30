package com.eureka.github.models.entity;

import javax.persistence.*;

@Table(name = "CODE_REVIEW")
@Entity
public class CodeReview {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private int id;

    @Column(name = "REPO_NAME")
    private String repoName;

    @Column(name = "REVIEW_ID")
    private int reviewId;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "IS_MERGED")
    private int isMerged;

    @Column(name = "STATE")
    private String state;

    @Column(name = "URL")
    private String url;

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

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsMerged() {
        return isMerged;
    }

    public void setIsMerged(int isMerged) {
        this.isMerged = isMerged;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
