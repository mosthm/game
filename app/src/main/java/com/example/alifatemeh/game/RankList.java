package com.example.alifatemeh.game;

import java.util.ArrayList;
import java.util.List;

public class RankList {
    private List<User> ranlList;
    public RankList(){
        ranlList = new ArrayList<>();
    }
    public  List<User> getRankList(){
        return ranlList;
    }

    public void setRanlList(List<User> ranlList) {
        this.ranlList = ranlList;
    }

    //add user to List
    public void addUserList(User user){
        ranlList.add(user);
    }
}
