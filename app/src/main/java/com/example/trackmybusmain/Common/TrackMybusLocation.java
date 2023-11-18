
package com.example.trackmybusmain.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.trackmybusmain.Common.BusTracking.TrackingBusRealTime;
import com.example.trackmybusmain.R;
import com.google.android.material.textfield.TextInputEditText;

public class TrackMybusLocation extends AppCompatActivity {

   TextInputEditText editTextBusNo = findViewById(R.id.busNotrackMybus); // Replace with your MaterialEditText ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_mybus_location);
    }

    public void trackOnMap(){
        String enteredBusNo = editTextBusNo.getText().toString().trim();
        if (!enteredBusNo.isEmpty()) {
            Intent intent = new Intent(this, TrackingBusRealTime.class);
            intent.putExtra("Bus_number", enteredBusNo);
            startActivity(intent);
        }else {
            Toast Toast = null;
            Toast.makeText(this, "Please enter a bus number", Toast.LENGTH_SHORT).show();
        }
    }
    
}