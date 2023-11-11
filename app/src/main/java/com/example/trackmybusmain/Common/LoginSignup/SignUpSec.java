package com.example.trackmybusmain.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trackmybusmain.Common.utility.NetworkChangeListner;
import com.example.trackmybusmain.R;

public class SignUpSec extends AppCompatActivity {
    NetworkChangeListner networkChangeListner = new NetworkChangeListner();
    ImageView btnback,signupImg;
    Button next,login;
    TextView getStarted,getGetStartedDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_sec);

        btnback = findViewById(R.id.btnSignUpBack);
        signupImg = findViewById(R.id.signUpPageImg);
        next = findViewById(R.id.btnNextSignUpPage);
        login = findViewById(R.id.btnLoginSignUpPage);
        getStarted = findViewById(R.id.textGetStartedSignup);
        getGetStartedDesc = findViewById(R.id.createAccSignup);

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
    public void signupBackSec(View view){
        Intent intent = new Intent(SignUpSec.this,SignUp.class);
        startActivity(intent);
    }
    public void signUpSecNext(View view){
        Intent intent = new Intent(SignUpSec.this, SignUpThird.class);
        startActivity(intent);
    }

    public void signupSecLogin(View view){
        Intent intent = new Intent(SignUpSec.this,Login.class);
        startActivity(intent);
    }

}