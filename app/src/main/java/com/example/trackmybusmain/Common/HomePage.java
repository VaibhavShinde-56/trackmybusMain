package com.example.trackmybusmain.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trackmybusmain.Common.BusTracking.TrackingBusRealTime;
import com.example.trackmybusmain.Common.TicketBooking.MyBookings;
import com.example.trackmybusmain.R;

public class HomePage extends AppCompatActivity {

    Button trackBusBtn;
    CardView busBookingCard,trackbusCard,cancelTicketCard,mybookingsCard,helplineCard,youprofileCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        trackBusBtn = findViewById(R.id.trackmyBusbtnHomePage);

        busBookingCard = findViewById(R.id.bookbuscardHomepage);
        trackbusCard = findViewById(R.id.trackbuscardHomepage);
        cancelTicketCard = findViewById(R.id.cancelticketcardHomepage);
        mybookingsCard = findViewById(R.id.mybookingscardHomepage);
        helplineCard = findViewById(R.id.helplinecardHomepage);
        youprofileCard = findViewById(R.id.profilecardHomepage);


        trackBusBtn.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(), TrackingBusRealTime.class);
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public void bookBus(View view) {
        Intent intent = new Intent(this, MyBookings.class);
        startActivity(intent);
    }

    public void trackBus(View view) {
        Intent intent = new Intent(this,TrackMybusLocation.class);
        startActivity(intent);
    }

    public void cancelTicket(View view) {
        Intent intent = new Intent(this, MyBookings.class);
        startActivity(intent);
    }

    public void myBookings(View view) {
        Intent intent = new Intent(this, MyBookings.class);
        startActivity(intent);
    }

    public void helpLine(View view) {
        Intent intent = new Intent(this, Helpline.class);
        startActivity(intent);
    }

    public void userProfile(View view) {
        Intent intent = new Intent(this, ProfileUser.class);
        startActivity(intent);
    }
}