package com.service.api.models;

public class UserStats {

    private int id;

    private String repoName;

    private int userId;

    private int commitCount;

    private int additionCount;

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
