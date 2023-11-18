package com.example.trackmybusmain.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trackmybusmain.Common.LoginSignup.StartScreen;
import com.example.trackmybusmain.Common.utility.NetworkChangeListner;
import com.example.trackmybusmain.R;
import com.example.trackmybusmain.helperclasses.SliderAdapter;

public class Onboarding extends AppCompatActivity {

    NetworkChangeListner networkChangeListner = new NetworkChangeListner();
    int currentPagePos;
    Animation animation;
    Button letsGetStarted;
    Button skipbtn;
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        //hooks
        viewPager = findViewById(R.id.viewPagerContainer);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.btnGetStarted);
        skipbtn = findViewById(R.id.btnOnboardSkip);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //default position will be 0
        addDots(0);

        //calling on page change listener
        viewPager.addOnPageChangeListener(changeListener);
    }
    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListner,filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListner);
        super.onStop();
    }

    public void skip(View view){
        SharedPreferences onboarding = getSharedPreferences("firstTime",MODE_PRIVATE);
        SharedPreferences.Editor editor = onboarding.edit();
        editor.putBoolean("firstTime",false);
        editor.commit();
        startActivity(new Intent(Onboarding.this, StartScreen.class));
        finish();
    }
    public void next(View view){
        viewPager.setCurrentItem(currentPagePos+1);
    }

    public void getStarted(View view){
        startActivity(new Intent(Onboarding.this,StartScreen.class));
        finish();
    }

    private void addDots(int position){
        dots = new TextView[3];
        //we are creating this explicitly so it is creating this views for each page we should clear them each time
        dotsLayout.removeAllViews();
        //create the textview insert the content to it and then add it to the dots layout
        for(int i = 0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(40);

            //add this dots on dots layout
            dotsLayout.addView(dots[i]);

        }
        //to change the color of dots of a page on which we are
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.text));
        }

    }
    //to get the current position of the page viewpager has a method
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);
            currentPagePos = position;
            if(position == 0 || position == 1){
                letsGetStarted.setVisibility(View.INVISIBLE);
            }else{
                animation = AnimationUtils.loadAnimation(Onboarding.this,R.anim.bottomanimation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



}