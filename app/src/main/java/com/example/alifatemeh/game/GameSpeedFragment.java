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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class GameSpeedFragment extends Fragment {
    private final int GAME_lEVEL_COUNT=10;
    private final int ones=0,nothings=1,boths=2;
    private final int Min_Int_Shape=1,Max_Int_Shape=9;

    private Button both;
    private Button nothing;
    private Button one;
    private TextView pointwhich;
    private TextView level;
    private TextView retimes;
    private ImageView firstImage;
    private ImageView flag_points;
    private TextView countDowns;
   // private ImageView firstImageArr[]=R.drawable.black_dayereh_24dp,;
    private ImageView secoundImage;
    private LinearLayout gameContainers;
    private LinearLayout buttonforgames;
    //**********************************************************************************************
    private int countDownInt=3;
    private int intShape[]={R.drawable.black_dayereh_24dp,R.drawable.black_moraba_24dp,R.drawable.black_mosalas_24dp,R.drawable.blue_dayereh_24dp,R.drawable.blue_moraba_24dp,R.drawable.blue_mosalas_24dp,R.drawable.green_dayereh_24dp,R.drawable.green_moraba_24dp,R.drawable.green_mosalas_24dp};
    private int gLevel=0;
    private int pointNum=0;
    private int shapeNum;
    private int shapeNum_first=0;
    private int shapeNum_secound=0;
    private int colorNum_first;
    private int colorNum_secound;
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
        return inflater.inflate(R.layout.fragment_gamesped,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findviews(view);
        intgenerateInt();
        configureViews();
        startCountDown();
    }

    private void intgenerateInt(){


        try {
            Random random =new Random();
            //if()
            int number = random.nextInt((Max_Int_Shape-Min_Int_Shape)+1)+Min_Int_Shape;
            //  if(intShape[number].)
            firstImage.setImageResource(intShape[number]);
            if(shapeNum_first==0){
                shapeNum_first=number;
            }else {
                shapeNum_secound=number;
            }

        }catch (Exception e){}


    }

    private void configureViews(){
        //point.setText(getString(R.string.user_points,0));

        both.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapeNum_first==0){
                    intgenerateInt();
                }else {
                    evaluateAndContinuGame(boths);
                    intgenerateInt();
                }
            }
        });
        nothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapeNum_first==0){
                    intgenerateInt();
                }else {
                    evaluateAndContinuGame(nothings);
                    intgenerateInt();
                }
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapeNum_first==0){
                    intgenerateInt();
                }else {
                    evaluateAndContinuGame(ones);
                    intgenerateInt();
                }
            }
        });
    }
    private  void  findviews(View view){
        // point.setText(getString(R.string.user_points,0));
        firstImage = (ImageView) view.findViewById(R.id.first_image);
        flag_points = (ImageView) view.findViewById(R.id.flag_point);
        secoundImage = (ImageView) view.findViewById(R.id.secound_image);
        both = (Button) view.findViewById(R.id.both);
        nothing =(Button) view.findViewById(R.id.nothing);
        one =(Button) view.findViewById(R.id.one);
        countDowns =(TextView) view.findViewById(R.id.count_down);
        retimes =(TextView) view.findViewById(R.id.tex_Time);
        pointwhich =(TextView) view.findViewById(R.id.tex_point);
        gameContainers =(LinearLayout) view.findViewById(R.id.game_container);
        buttonforgames=(LinearLayout) view.findViewById(R.id.buttonforgame);
    }
    private  void evaluateAndContinuGame(int whichPress){
        if(gameIntProgress==false){
            return;
        }else {
            evalute(whichPress);
         //   point.setText(getString(R.string.user_points,pointNum));
            //generateNum();
            intgenerateInt();
        }
    }
    private void evalute(int flag){

//        if(gLevel==GAME_lEVEL_COUNT){
//            return;
//        }else {
        if(flag==boths){
            if(shapeNum_first==shapeNum_secound){
                pointNum++;
                flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else {
                flag_points.setImageResource(R.drawable.ic_close_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }
        }else if (flag==ones){
            if(shapeNum_first==1){
                if(shapeNum_secound==4||shapeNum_secound==7)
                {
                    pointNum++;
                    flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==2){
                if(shapeNum_secound==5||shapeNum_secound==8)
                {
                    pointNum++;
                    flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==3){
                if(shapeNum_secound==6||shapeNum_secound==9)
                {
                    pointNum++;
                    flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if(shapeNum_secound<=3&&shapeNum_first<=3){
                pointNum++;
                flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else {
                flag_points.setImageResource(R.drawable.ic_close_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }
        }else if(flag==nothings){
            if(!(shapeNum_first==shapeNum_secound)){
                pointNum++;
                flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else if(shapeNum_first==1){
                if(!(shapeNum_secound==4)||!(shapeNum_secound==7))
                {
                    pointNum++;
                    flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==2){
                if(!(shapeNum_secound==5)||!(shapeNum_secound==8))
                {
                    pointNum++;
                    flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==3){
                if(!(shapeNum_secound==6)||!(shapeNum_secound==9))
                {
                    pointNum++;
                    flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if(!(shapeNum_secound<=3)&&!(shapeNum_first<=3)){
                pointNum++;
                flag_points.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else {

                flag_points.setImageResource(R.drawable.ic_close_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }
        }

//        }

    }
    private void startCountDown(){
        ObjectAnimator scaleXAnimation =ObjectAnimator.ofFloat(
                countDowns,"scaleX",1f,2f,1.5f,3f
        );
        scaleXAnimation.setDuration(1000);
        ObjectAnimator scaleYAnimation =ObjectAnimator.ofFloat(
                countDowns,"scaleY",1f,2f,1.5f,3f
        );
        scaleYAnimation.setDuration(1000);
        ObjectAnimator rotateAnimation =ObjectAnimator.ofFloat(
                countDowns,"rotation",0f,180f,360f
        );
        rotateAnimation.setDuration(1000);
        ObjectAnimator alphaAnimation =ObjectAnimator.ofFloat(
                countDowns,"alpha",1f,0f
        );
        alphaAnimation.setDuration(1000);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(scaleXAnimation,scaleYAnimation,rotateAnimation,alphaAnimation);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (countDownInt==0){
                    gameContainers.setVisibility(View.VISIBLE);
                    buttonforgames.setVisibility(View.VISIBLE);
                    startGame();

                }else {
                    startCountDown();}
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                countDowns.setText(String.valueOf(countDownInt));
                countDownInt --;
            }
        });
        animatorSet.start();

    }
    private void falgPoint(){
        ObjectAnimator scaleXAnimation =ObjectAnimator.ofFloat(
                flag_points,"scaleX",1f,2f,1.5f,3f
        );
        scaleXAnimation.setDuration(1000);
        ObjectAnimator scaleYAnimation =ObjectAnimator.ofFloat(
                flag_points,"scaleY",1f,2f,1.5f,3f
        );
        scaleYAnimation.setDuration(1000);
        ObjectAnimator rotateAnimation =ObjectAnimator.ofFloat(
                flag_points,"rotation",0f,180f,360f
        );
        rotateAnimation.setDuration(1000);
        ObjectAnimator alphaAnimation =ObjectAnimator.ofFloat(
                flag_points,"alpha",1f,0f
        );
        alphaAnimation.setDuration(100);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(scaleXAnimation,scaleYAnimation,rotateAnimation,alphaAnimation);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                flag_points.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                flag_points.setVisibility(View.VISIBLE);
            }
        });
        animatorSet.start();

    }
    private void startGame(){

        countdowntim = new CountDownTimer(8000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                retimes.setText(getString(R.string.game_time,(int)(millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
                retimes.setText("Game Finish");
                updateHighScore();
                buttonforgames.setVisibility(View.INVISIBLE);
                gameContainers.setVisibility(View.INVISIBLE);
                pointwhich.setVisibility(View.VISIBLE);
                pointwhich.setText(getString(R.string.user_points,pointNum));
//                equal.setVisibility(View.INVISIBLE);
            }
        };
        countdowntim.start();
        gameIntProgress=true;
        intgenerateInt();
      //  generateNum();
    }
    private void updateHighScore(){
//      get rank list
        RankListSpeed rankListSpeed =MyPrefrenceManger.getInstance(getActivity()).getRankListSpeed();
        UserSpeed newUser =new UserSpeed();
        newUser.setName(playerName);
        newUser.setScore(pointNum);
        rankListSpeed.addUserListSpeed(newUser);
        //save rank list in sha=eredprefernce
        MyPrefrenceManger.getInstance(getActivity()).putRankListSpeed(rankListSpeed);

    }
}
