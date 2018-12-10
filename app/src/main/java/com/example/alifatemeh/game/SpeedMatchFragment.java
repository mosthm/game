package com.example.alifatemeh.game;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SpeedMatchFragment extends Fragment {
    private Button startGame;
    private Button showBestScore;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speedmatch, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        configure();

//        User bestUser =MyPrefrenceManger.getInstance(getActivity()).getBestUser();
//        highScore.setText("Best Score : "+bestUser.getScore() + " from " + bestUser.getName());
        //configureRankList();
    }
    private void findViews(View view){
        startGame=(Button) view.findViewById(R.id.start_game);
        showBestScore=(Button) view.findViewById(R.id.best_score);
    }
    private void configure(){
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetNameDialog getNameDialog=new GetNameDialog(
                        getActivity()
                        , new OnNameSellectedListener() {
                    @Override
                    public void onNameSlected(String playerName) {
                        GameSpeedFragment gameSpeedFragment = new GameSpeedFragment();
                        Bundle bundle =new Bundle();
                        bundle.putString("player_name",playerName);
                        gameSpeedFragment.setArguments(bundle);
                        getFragmentManager().beginTransaction()
                                .add(R.id.frag_container,gameSpeedFragment)
                                .addToBackStack(null)
                                .commit();
                    }
                }
                );
                getNameDialog.show();
            }
        });
        showBestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                BestScoreFragment bestScoreFragment = new BestScoreFragment();
//                getFragmentManager().beginTransaction()
//                        .add(R.id.frag_container,bestScoreFragment)
//                        .addToBackStack(null)
//                        .commit();
            }
        });
    }
}
