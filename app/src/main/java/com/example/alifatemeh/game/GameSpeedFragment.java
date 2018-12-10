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
    private final int Left_Button=0,Right_Button=1,Equal_Button=2;
    private final int Min_Int_Shape=1,Max_Int_Shape=9;

    private Button both;
    private Button nothing;
    private Button one;
    private TextView point;
    private TextView level;
    private TextView retime;
    private ImageView firstImage;
    private TextView countDown;
   // private ImageView firstImageArr[]=R.drawable.black_dayereh_24dp,;
    private ImageView secoundImage;
    private LinearLayout gameContainer;
    //**********************************************************************************************
    private int countDownInt=3;
    private int gLevel=0;
    private int pointNum=0;
    private int shapeNum;
    private int shapeNum_first;
    private int shapeNum_secound;
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
//        configureViews();
//        startCountDown();

        shapeNum=intgenerateInt();
        //point.setText(String.valueOf(shapeNum));
        firstImage.setImageResource(R.drawable.black_dayereh_24dp);

    }

    private int intgenerateInt(){

        Random random =new Random();
        int number = random.nextInt((Max_Int_Shape-Min_Int_Shape)+1)+Min_Int_Shape;
        return number;
    }

    private void configureViews(){
        //point.setText(getString(R.string.user_points,0));

        both.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Left_Button);
            }
        });
        nothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Right_Button);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Equal_Button);
            }
        });
    }
    private  void  findviews(View view){
        // point.setText(getString(R.string.user_points,0));
        firstImage = (ImageView) view.findViewById(R.id.first_image);
        secoundImage = (ImageView) view.findViewById(R.id.secound_image);
        both = (Button) view.findViewById(R.id.both);
        nothing =(Button) view.findViewById(R.id.nothing);
        one =(Button) view.findViewById(R.id.one);
    }
}
