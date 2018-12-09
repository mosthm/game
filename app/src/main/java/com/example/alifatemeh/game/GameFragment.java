package com.example.alifatemeh.game;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class GameFragment extends Fragment {
    private final int GAME_lEVEL_COUNT=10;
    private final int Left_Button=0,Right_Button=1,Equal_Button=2;

    private Button leftNumber;
    private Button rightNumber;
    private Button equal;
    private TextView point;
    private TextView level;
    private TextView retime;
    private TextView countDown;
    private LinearLayout gameContainer;
    //**********************************************************************************************
    private int countDownInt=3;
    private int gLevel=0;
    private int pointNum=0;
    private int leftNum;
    private int rightNum;
    private boolean gameIntProgress = false;
    //**********************************************************************************************
    private CountDownTimer countdowntim;
    private String playerName;
    //**********************************************************************************************
    private void readArguments(){
        playerName=getArguments().getString("player_name",null);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        readArguments();
        return inflater.inflate(R.layout.fragment_game,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findviews(view);
        configureViews();
        startCountDown();
    }
    private void startGame(){

        countdowntim = new CountDownTimer(8000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                retime.setText(getString(R.string.game_time,(int)(millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
                retime.setText("Game Finish");
                updateHighScore();
                leftNumber.setVisibility(View.INVISIBLE);
                rightNumber.setVisibility(View.INVISIBLE);
                equal.setVisibility(View.INVISIBLE);
            }
        };
        countdowntim.start();
        gameIntProgress=true;
        generateNum();
    }
    private void startCountDown(){
        ObjectAnimator scaleXAnimation =ObjectAnimator.ofFloat(
                countDown,"scaleX",1f,2f,1.5f,3f
        );
        scaleXAnimation.setDuration(1000);
        ObjectAnimator scaleYAnimation =ObjectAnimator.ofFloat(
                countDown,"scaleY",1f,2f,1.5f,3f
        );
        scaleYAnimation.setDuration(1000);
        ObjectAnimator rotateAnimation =ObjectAnimator.ofFloat(
                countDown,"rotation",0f,180f,360f
        );
        rotateAnimation.setDuration(1000);
        ObjectAnimator alphaAnimation =ObjectAnimator.ofFloat(
                countDown,"alpha",1f,0f
        );
        alphaAnimation.setDuration(1000);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(scaleXAnimation,scaleYAnimation,rotateAnimation,alphaAnimation);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (countDownInt==0){
                    gameContainer.setVisibility(View.VISIBLE);
                    startGame();
                }else {
                    startCountDown();}
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                countDown.setText(String.valueOf(countDownInt));
                countDownInt --;
            }
        });
        animatorSet.start();

    }
    public void testAnimate(){
        equal.setRotation(180f);
    }
    @Override
    public void onPause() {
        super.onPause();
        countdowntim.cancel();
    }
    private void updateHighScore(){
//      get rank list
        RankList ranklist =MyPrefrenceManger.getInstance(getActivity()).getRankList();
        User newUser =new User();
        newUser.setName(playerName);
        newUser.setScore(pointNum);
        ranklist.addUserList(newUser);
        //save rank list in sha=eredprefernce
        MyPrefrenceManger.getInstance(getActivity()).putRannkList(ranklist);

//        User previouseUser =MyPrefrenceManger.getInstance(getActivity()).getBestUser();
//        if(previouseUser==null||previouseUser.getScore()<pointNum){
//            User newUser =new User();
//            newUser.setName(playerName);
//            newUser.setScore(pointNum);
//            MyPrefrenceManger.getInstance(getActivity()).putBestUser(newUser);
//        }
//        int previouseHighScore = MyPrefrenceManger.getInstance(getActivity()).getHighScore();
//        if (previouseHighScore<pointNum){
//            MyPrefrenceManger.getInstance(getActivity()).putHighScore(pointNum);
//        }
    }
    private void configureViews(){
        //point.setText(getString(R.string.user_points,0));

        leftNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Left_Button);
            }
        });
        rightNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Right_Button);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Equal_Button);
            }
        });
    }
    private  void evaluateAndContinuGame(int whichPress){
        if(gameIntProgress==false){
            return;
        }else {
            evalute(whichPress);
            point.setText(getString(R.string.user_points,pointNum));
            generateNum();
        }
    }
    private void evalute(int flag){

//        if(gLevel==GAME_lEVEL_COUNT){
//            return;
//        }else {
        if(flag==Left_Button){
            if(leftNum>rightNum){
                pointNum++;
            }
        }else if(flag==Right_Button){
            if(leftNum<rightNum){
                pointNum++;
            }
        }else if (flag==Equal_Button){
            if(leftNum==rightNum){
                pointNum++;
            }
        }
//        }

    }
    private  void  findviews(View view){
        // point.setText(getString(R.string.user_points,0));
        leftNumber = (Button) view.findViewById(R.id.left_Number);
        rightNumber =(Button) view.findViewById(R.id.right_Number);
        equal =(Button) view.findViewById(R.id.equal);
        point =(TextView) view.findViewById(R.id.tex_point);
        //level =(TextView) view.findViewById(R.id.tex_Level);
        retime =(TextView) view.findViewById(R.id.tex_Time);
        countDown =(TextView) view.findViewById(R.id.count_down);
        gameContainer =(LinearLayout) view.findViewById(R.id.game_container);
    }
    private int intgenerateInt(){
        Random random =new Random();
        int number = random.nextInt();
        if (number<0){
            number = number * -1;
        }
        number = number % 30;
        return number;
    }
    private void generateNum(){

        if(gameIntProgress==false){
            level.setText("Game Finish");
            return;
        }else {
//            if(gLevel==GAME_lEVEL_COUNT){
//                return;
//            }
//            else {
//                gLevel ++;
//                //level.setText(String.valueOf(gLevel));
//                level.setText(getString(R.string.game_level,gLevel,GAME_lEVEL_COUNT));
//            }
        }
        leftNum=intgenerateInt();
        rightNum=intgenerateInt();
        leftNumber.setText(String.valueOf(leftNum));
        rightNumber.setText(String.valueOf(rightNum));

    }
}
