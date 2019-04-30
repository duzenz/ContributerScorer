package com.eureka.github.models.entity;

import javax.persistence.*;

@Table(name = "USERSTATS")
@Entity
public class UserStats {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false)
    private int id;

    @Column(name = "REPO_NAME")
    private String repoName;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "COMMIT_COUNT")
    private int commitCount;

    @Column(name = "ADDITION_COUNT")
    private int additionCount;

    @Column(name = "DELETION_COUNT")
    private int deletionCount;

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

    public int getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }

    public int getAdditionCount() {
        return additionCount;
    }

    public void setAdditionCount(int additionCount) {
        this.additionCount = additionCount;
    }

    public int getDeletionCount() {
        return deletionCount;
    }

    public void setDeletionCount(int deletionCount) {
        this.deletionCount = deletionCount;
    }
}
