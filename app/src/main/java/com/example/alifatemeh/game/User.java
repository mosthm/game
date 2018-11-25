package com.example.alifatemeh.game;

public class User {
    private  Integer score;
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {

        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
