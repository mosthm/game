package com.example.alifatemeh.game;

import java.util.ArrayList;
import java.util.List;

public class RankListSpeed {
    private List<UserSpeed> rankListSpeed;
    public RankListSpeed(){
        rankListSpeed = new ArrayList<>();
    }
    public  List<UserSpeed> getRankListSpeed(){
        return rankListSpeed;
    }

    public void setRankListSpeed(List<UserSpeed> rankListSpeed) {
        this.rankListSpeed = rankListSpeed;
    }

    //add user to List
    public void addUserListSpeed(UserSpeed user){
        rankListSpeed.add(user);
    }
}
