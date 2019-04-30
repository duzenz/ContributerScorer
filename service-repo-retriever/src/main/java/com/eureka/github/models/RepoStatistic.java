package com.eureka.github.models;

import java.util.List;

public class RepoStatistic {
    private int total;
    private List<RepoStatWeek> weeks;
    private Author author;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RepoStatWeek> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<RepoStatWeek> weeks) {
        this.weeks = weeks;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "RepoStatistic{" +
                "total=" + total +
                ", weeks=" + weeks +
                ", author=" + author +
                '}';
    }
}
