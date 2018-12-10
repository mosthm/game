package com.example.alifatemeh.game;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;

public class BestScoreFragment extends Fragment {
    UserAdapter userAdapter;
    RecyclerView ranklist;
    TextView highScore;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_best_score, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findviews(view);

//        User bestUser =MyPrefrenceManger.getInstance(getActivity()).getBestUser();
//        highScore.setText("Best Score : "+bestUser.getScore() + " from " + bestUser.getName());
        configureRankList();
    }
    public void configureRankList(){
        RankList rankListObject= MyPrefrenceManger.getInstance(getActivity()).getRankList();
        Comparator<User> userComparetor = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.getScore()>o2.getScore()){
                    return -1;
                }else if(o1.getScore()<o2.getScore()){
                    return +1;
                }else {
                    return 0;
                }

            }

        };
        Collections.sort(rankListObject.getRankList(),userComparetor);
        userAdapter =new UserAdapter(rankListObject.getRankList());
        ranklist.setLayoutManager(new LinearLayoutManager(getActivity()));
        ranklist.setAdapter(userAdapter);
    }
    private void findviews(View view){
        ranklist =(RecyclerView ) view.findViewById(R.id.ranklist);
        highScore = (TextView) view.findViewById(R.id.high_score);
    }
}
