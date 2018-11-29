package com.example.alifatemeh.game;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//    Button gameWhich;
//    Button gameSpeed;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        findViews();
        configure();
    }
    private void findViews(){

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
    }

    private void configure(){

        myFragmentPagerAdapter =new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentPagerAdapter);
        //connect tablayout to viewpager
        tabLayout.setupWithViewPager(viewPager);
      //  viewPager.setCurrentItem(1);

//        gameWhich.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WhichOneFragment whichOneFragment = new WhichOneFragment();
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.frag_container,whichOneFragment)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });
//        gameSpeed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SpeedMatchFragment speedMatchFragment = new SpeedMatchFragment();
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.frag_container,speedMatchFragment)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });
    }
}
