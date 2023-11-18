package com.example.trackmybusmain.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trackmybusmain.Common.BusTracking.TrackingBusRealTime;
import com.example.trackmybusmain.Common.TicketBooking.MainActivity;
import com.example.trackmybusmain.Common.TicketBooking.MainActivity2;
import com.example.trackmybusmain.Common.TicketBooking.MyBookings;
import com.example.trackmybusmain.R;
import com.google.android.material.textfield.TextInputEditText;

public class HomePage extends AppCompatActivity {

    Button trackBusBtn;
    CardView busBookingCard,trackbusCard,cancelTicketCard,mybookingsCard,helplineCard,youprofileCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TextInputEditText editTextBusNo = findViewById(R.id.busnoedittexthomepage); // Replace with your MaterialEditText ID
        trackBusBtn = findViewById(R.id.trackmyBusbtnHomePage);

        busBookingCard = findViewById(R.id.bookbuscardHomepage);
        trackbusCard = findViewById(R.id.trackbuscardHomepage);
        cancelTicketCard = findViewById(R.id.cancelticketcardHomepage);
        mybookingsCard = findViewById(R.id.mybookingscardHomepage);
        helplineCard = findViewById(R.id.helplinecardHomepage);
        youprofileCard = findViewById(R.id.profilecardHomepage);


        trackBusBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String enteredBusNo = editTextBusNo.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(), TrackingBusRealTime.class);
                intent.putExtra("Bus_number", enteredBusNo);
                startActivity(intent);
            }
        });
    }

    public void bookBus(View view) {
        Intent intent = new Intent(this, MainActivity.class);
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

    public void trackBuslocation(View view) {
        Intent intent = new Intent(getApplicationContext(), TrackMybusLocation.class);
        startActivity(intent);
    }
}