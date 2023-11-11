package com.example.trackmybusmain.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.trackmybusmain.Common.LoginSignup.StartScreen;
import com.example.trackmybusmain.Common.utility.NetworkChangeListner;
import com.example.trackmybusmain.R;

public class Splashmainpage extends AppCompatActivity {
    NetworkChangeListner networkChangeListner = new NetworkChangeListner();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashmainpage);

        //shared preferences
        SharedPreferences onBoarding;

        TextView txtappname,txtdesc;

       //get framlayout id for onclick on animtion
        FrameLayout animationnextpage = findViewById(R.id.animationnextpage);

        //getting id of textviews
        txtappname = findViewById(R.id.txtappname);
        txtdesc = findViewById(R.id.txtdesc);

        //text animation
        Animation alphAnime = AnimationUtils.loadAnimation(this,R.anim.logoanimation);

        txtappname.startAnimation(alphAnime);
        txtdesc.startAnimation(alphAnime);

        //making the next page button appear late 

        animationnextpage.setVisibility(View.INVISIBLE);
        animationnextpage.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationnextpage.setVisibility(View.VISIBLE);
            }
        },2000);

        Intent nextishome = new Intent(Splashmainpage.this, Onboarding.class);

        SharedPreferences onboarding = getSharedPreferences("firstTime",MODE_PRIVATE);
        //final boolean[] sharedPrefValue = new boolean[1];

        //splash screen logic
        Handler myhandler = new Handler();
        Runnable myrunnable = new Runnable() {
            @Override
            public void run() {
                    boolean checkfirstTime = onboarding.getBoolean("firstTime",true);
                    if(checkfirstTime){
                        startActivity(nextishome);
                        finish();
                    }else{
                        startActivity(new Intent(Splashmainpage.this, StartScreen.class));
                        finish();
                    }
            }
        };
        myhandler.postDelayed(myrunnable,15000);

        //on click animation next page logic
        animationnextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    boolean isFirstTime = onboarding.getBoolean("firstTime",true);
                    if(!(isFirstTime)){
                        startActivity(new Intent(Splashmainpage.this,StartScreen.class));
                        finish();
                    }else{
                        startActivity(nextishome);
                        finish();
                    }
                    
            }
        });



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

}