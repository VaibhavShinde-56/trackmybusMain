
package com.example.trackmybusmain.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.trackmybusmain.Common.BusTracking.TrackingBusRealTime;
import com.example.trackmybusmain.R;

public class TrackMybusLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_mybus_location);
    }

    public void trackOnMap(){
        Intent intent = new Intent(this, TrackingBusRealTime.class);
        startActivity(intent);
    }


}