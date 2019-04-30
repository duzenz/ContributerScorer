package com.eureka.github.models;

public class RepoStatWeek {
    private long w;
    private int a;
    private int d;
    private int c;

    public long getW() {
        return w;
    }

    public void setW(long w) {
        this.w = w;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "RepoStatWeek{" +
                "w=" + w +
                ", a=" + a +
                ", d=" + d +
                ", c=" + c +
                '}';
    }
}
