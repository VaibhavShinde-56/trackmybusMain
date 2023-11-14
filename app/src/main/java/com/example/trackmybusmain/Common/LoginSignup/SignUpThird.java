package com.example.trackmybusmain.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;

import com.example.trackmybusmain.Common.TicketBooking.MyBookings;
import com.example.trackmybusmain.Common.utility.NetworkChangeListner;
import com.example.trackmybusmain.R;

public class SignUpThird extends AppCompatActivity {

    NetworkChangeListner networkChangeListner = new NetworkChangeListner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_third);
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

    public void signupBack(View view) {
        Intent intent = new Intent(SignUpThird.this, SignUpSec.class);
        startActivity(intent);
    }
    public void login(View view) {
        Intent intent = new Intent(SignUpThird.this, Login.class);
        startActivity(intent);
    }

    public void SignupNextThird(View view) {
        Intent intent = new Intent(SignUpThird.this, MyBookings.class);
        startActivity(intent);
    }
}