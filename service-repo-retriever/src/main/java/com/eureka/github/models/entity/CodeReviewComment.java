package com.eureka.github.models.entity;

import javax.persistence.*;

@Table(name = "CODE_REVIEW_COMMENT")
@Entity
public class CodeReviewComment {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private int id;

    @Column(name = "REPO_NAME")
    private String repoName;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "COMMENT_ID")
    private int commentId;

    @Column(name = "COMMENT_URL")
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
