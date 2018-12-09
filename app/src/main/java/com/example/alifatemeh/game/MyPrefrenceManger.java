package com.example.alifatemeh.game;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class MyPrefrenceManger {
    private static MyPrefrenceManger instance =null;
    private SharedPreferences sharedPreferences=null;
    private SharedPreferences.Editor editor=null;
    public static MyPrefrenceManger getInstance(Context context){
        if(instance==null){
            instance=new MyPrefrenceManger(context);
        }
        return instance;
    }
    private MyPrefrenceManger(Context context){
        sharedPreferences =context.getSharedPreferences("my_preference",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //editor.pu
    }

    //******************************************************************

    public int getHighScore(){
        return sharedPreferences.getInt("high_score",0);
    }
    public  void putHighScore(int highScore){
        //use of editor then write
        editor.putInt("high_score",highScore);
        editor.apply();
    }
    //******************************************************************

    public void putBestUser(User bestUser){
        Gson gson =new Gson();
        String userJson = gson.toJson(bestUser,User.class);
        editor.putString("best_user",userJson);
        editor.apply();
    }
    public User getBestUser(){
        String userJson=sharedPreferences.getString("best_user",null);
        if(userJson==null){
            return null;
        }
        Gson gson=new Gson();
        return gson.fromJson(userJson,User.class);
    }
//    //******************************************************************
    public void putRannkList (RankList rankList){
        Gson gson=new Gson();
        String rankListJson=gson.toJson(rankList,RankList.class);
        editor.putString("ranklist",rankListJson);
        editor.apply();
    }
    public RankList getRankList(){
        String rankListJson = sharedPreferences.getString("ranklist",null);
        if(rankListJson==null){
            return new RankList();
        }
        Gson gson=new Gson();
        return gson.fromJson(rankListJson,RankList.class);
    }
}
