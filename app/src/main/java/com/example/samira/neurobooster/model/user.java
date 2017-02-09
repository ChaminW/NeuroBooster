package com.example.samira.neurobooster.model;

/**
 * Created by Samira on 5/28/16.
 */
public class user {
    int id;
    String name;
    int score;
    String time;

    public user() {
    }

    public user(int id, String name, int score, String time) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
