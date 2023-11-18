package com.example.trackmybusmain.Common.TicketBooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.trackmybusmain.R;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    Button button2 ;
    private Button search;
    int hr , min ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button2 = findViewById(R.id.button2);
        search = (Button) findViewById(R.id.srch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
    }
    public void openActivity3()
    {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void poptimePicker(View v)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHr, int selectedMin) {
                hr = selectedHr ;
                min = selectedMin ;
                button2.setText(String.format(Locale.getDefault(), "%format:" + "%02d:%02d", hr, min));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener,hr ,min,true);
        timePickerDialog.setTitle(("Select Time : "));
        timePickerDialog.show();
    }

}