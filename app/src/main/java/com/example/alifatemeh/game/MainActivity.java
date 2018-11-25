package com.example.alifatemeh.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button gameWhich;
    Button gameSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        configure();
    }
    private void findViews(){
        gameWhich=(Button) findViewById((R.id.game_which));
        gameSpeed=(Button) findViewById((R.id.game_speed));
    }

    private void configure(){
        gameWhich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WhichOneFragment whichOneFragment = new WhichOneFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frag_container,whichOneFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        gameSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeedMatchFragment speedMatchFragment = new SpeedMatchFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frag_container,speedMatchFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
