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
    private TextView point;
    private TextView level;
    private TextView retime;
    private ImageView firstImage;
    private ImageView flag_point;
    private TextView countDown;
   // private ImageView firstImageArr[]=R.drawable.black_dayereh_24dp,;
    private ImageView secoundImage;
    private LinearLayout gameContainer;
    private LinearLayout buttonforgame;
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
        //readArguments();
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
        flag_point = (ImageView) view.findViewById(R.id.flag_point);
        secoundImage = (ImageView) view.findViewById(R.id.secound_image);
        both = (Button) view.findViewById(R.id.both);
        nothing =(Button) view.findViewById(R.id.nothing);
        one =(Button) view.findViewById(R.id.one);
        countDown =(TextView) view.findViewById(R.id.count_down);
        retime =(TextView) view.findViewById(R.id.tex_Time);
        point =(TextView) view.findViewById(R.id.tex_point);
        gameContainer =(LinearLayout) view.findViewById(R.id.game_container);
        buttonforgame =(LinearLayout) view.findViewById(R.id.buttonforgame);
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
                flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else {
                flag_point.setImageResource(R.drawable.ic_close_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }
        }else if (flag==ones){
            if(shapeNum_first==1){
                if(shapeNum_secound==4||shapeNum_secound==7)
                {
                    pointNum++;
                    flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==2){
                if(shapeNum_secound==5||shapeNum_secound==8)
                {
                    pointNum++;
                    flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==3){
                if(shapeNum_secound==6||shapeNum_secound==9)
                {
                    pointNum++;
                    flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if(shapeNum_secound<=3&&shapeNum_first<=3){
                pointNum++;
                flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else {
                flag_point.setImageResource(R.drawable.ic_close_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }
        }else if(flag==nothings){
            if(!(shapeNum_first==shapeNum_secound)){
                pointNum++;
                flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else if(shapeNum_first==1){
                if(!(shapeNum_secound==4)||!(shapeNum_secound==7))
                {
                    pointNum++;
                    flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==2){
                if(!(shapeNum_secound==5)||!(shapeNum_secound==8))
                {
                    pointNum++;
                    flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if (shapeNum_first==3){
                if(!(shapeNum_secound==6)||!(shapeNum_secound==9))
                {
                    pointNum++;
                    flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                    falgPoint();
                    shapeNum_first=shapeNum_secound;
                }
            }else if(!(shapeNum_secound<=3)&&!(shapeNum_first<=3)){
                pointNum++;
                flag_point.setImageResource(R.drawable.ic_check_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }else {

                flag_point.setImageResource(R.drawable.ic_close_black_24dp);
                falgPoint();
                shapeNum_first=shapeNum_secound;
            }
        }

//        }

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
                    buttonforgame.setVisibility(View.VISIBLE);
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
    private void falgPoint(){
        ObjectAnimator scaleXAnimation =ObjectAnimator.ofFloat(
                flag_point,"scaleX",1f,2f,1.5f,3f
        );
        scaleXAnimation.setDuration(1000);
        ObjectAnimator scaleYAnimation =ObjectAnimator.ofFloat(
                flag_point,"scaleY",1f,2f,1.5f,3f
        );
        scaleYAnimation.setDuration(1000);
        ObjectAnimator rotateAnimation =ObjectAnimator.ofFloat(
                flag_point,"rotation",0f,180f,360f
        );
        rotateAnimation.setDuration(1000);
        ObjectAnimator alphaAnimation =ObjectAnimator.ofFloat(
                flag_point,"alpha",1f,0f
        );
        alphaAnimation.setDuration(100);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(scaleXAnimation,scaleYAnimation,rotateAnimation,alphaAnimation);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                flag_point.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                flag_point.setVisibility(View.VISIBLE);
            }
        });
        animatorSet.start();

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
                buttonforgame.setVisibility(View.INVISIBLE);
                gameContainer.setVisibility(View.INVISIBLE);
                point.setVisibility(View.VISIBLE);
                point.setText(getString(R.string.user_points,pointNum));
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
        RankList ranklist =MyPrefrenceManger.getInstance(getActivity()).getRankList();
        User newUser =new User();
        newUser.setName(playerName);
        newUser.setScore(pointNum);
        ranklist.addUserList(newUser);
        //save rank list in sha=eredprefernce
        MyPrefrenceManger.getInstance(getActivity()).putRannkListSpeed(ranklist);

    }
}
