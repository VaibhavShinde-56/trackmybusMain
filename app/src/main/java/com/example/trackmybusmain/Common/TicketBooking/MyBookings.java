package com.example.trackmybusmain.Common.TicketBooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.trackmybusmain.R;

import java.util.ArrayList;

public class MyBookings extends AppCompatActivity {

    ArrayList<TicketModel> tickets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tickets.add(new TicketModel("kolhapur","sangli","2:00","4:00","12nov2023","12nov2023","4","abcd2345","xyz1234"));

        tickets.add(new TicketModel("kolhapur","miraj","2:00","4:00","12nov2023","12nov2023","2","abcd4455","xyz0098"));

        tickets.add(new TicketModel("ichalkaranji","sangli","2:00","4:00","12nov2023","12nov2023","3","abcd6969","xyz8585"));

        tickets.add(new TicketModel("kurundwad","sangli","2:00","4:00","12nov2023","12nov2023","5","abcd3456","xyz4567"));

        RecyclerAdapter rcadapter = new RecyclerAdapter(this,tickets);
        recyclerView.setAdapter(rcadapter);
    }
    void viewTicket(View view){
        Intent intent = new Intent(this, ShowTicket.class);
        startActivity(intent);
    }

}