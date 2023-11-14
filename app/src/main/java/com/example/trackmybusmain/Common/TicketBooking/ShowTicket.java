package com.example.trackmybusmain.Common.TicketBooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.trackmybusmain.R;

import org.w3c.dom.Text;

public class ShowTicket extends AppCompatActivity {

    TextView busNo,fromCity,toCity,boardDate,boardTime,ticketId;
    Button cancleTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ticket);

        //hooks
        busNo = findViewById(R.id.busNoTicketDetails);
        fromCity = findViewById(R.id.fromCityTicketDetails);
        toCity = findViewById(R.id.toCityTicketDetails);
        boardDate = findViewById(R.id.boardingDateTicketDetails);
        boardTime = findViewById(R.id.boardingTimeTicketDetails);
        ticketId = findViewById(R.id.ticketIdTicketDetails);
        cancleTicket = findViewById(R.id.btnCancleTicket);



        Intent fromRecycler = getIntent();
        busNo.setText(fromRecycler.getStringExtra("busNo"));
        fromCity.setText(fromRecycler.getStringExtra("fromCityName"));
        toCity.setText(fromRecycler.getStringExtra("toCityName"));
        boardDate.setText(fromRecycler.getStringExtra("onBoardDate"));
        boardTime.setText(fromRecycler.getStringExtra("onBoardTime"));
        ticketId.setText(fromRecycler.getStringExtra("ticketId"));


    }
}