package com.example.trackmybusmain.Common.BusTracking;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trackmybusmain.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.trackmybusmain.databinding.ActivityTrackingBusRealTimeBinding;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class TrackingBusRealTime extends FragmentActivity implements OnMapReadyCallback {

    private final int FINE_PERMISSION_CODE = 1;
    LatLng  destinationLocation;
    private GoogleMap mMap;
    LatLng currentLocation1;
    Handler handler;
    Button btnTrackBus;
    private Marker myLocationMarker;
    long refreshTime = 5000; //5 secs
    Runnable runnable;
    String locationString = null;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private ActivityTrackingBusRealTimeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting location entered by user

        Intent intent = getIntent();
        if(intent!=null){
            locationString = intent.getStringExtra("Bus_number");
        }else{
            Toast.makeText(this, "please enter bus no", Toast.LENGTH_SHORT).show();
        }

        binding = ActivityTrackingBusRealTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();

        btnTrackBus = findViewById(R.id.trackmybusmap);
        btnTrackBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPolyline();
            }
        });


//        if (!locationString.isEmpty()) {
//            String[] coordinates = locationString.split(","); // Assuming format: "latitude,longitude"
//            if (coordinates.length == 2) {
//
//                Log.d("LocationString", locationString);
//                double destinationLatitude = Double.parseDouble(coordinates[0]);
//                double destinationLongitude = Double.parseDouble(coordinates[1]);
//                Log.d("DestinationCoordinates", "Lat: " + destinationLatitude + ", Long: " + destinationLongitude);
//
//                LatLng destination = new LatLng(16.682567, 74.4704024);
//                drawPolyline(destination);
//            } else {
//                Toast.makeText(TrackingBusRealTime.this, "Invalid location format", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(TrackingBusRealTime.this, "Please enter location", Toast.LENGTH_SHORT).show();
//        }


        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,refreshTime);
                getLastLocation();
            }
        },refreshTime);

    }
    private void drawPolyline() {
        if (mMap != null) {
            mMap.addPolyline(new PolylineOptions().add(currentLocation1, destinationLocation).width(5).color(Color.BLUE));
        } else {
            Log.d("Debug", "Map is not ready yet");
        }
    }



    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_PERMISSION_CODE);
            return;
        }

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){

                    currentLocation = location;
                    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(TrackingBusRealTime.this);
                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        double destinationLatitude = 0;
        double destinationLongitude = 0;
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        if(myLocationMarker == null) {
            LatLng ichlatLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
            currentLocation1 = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions().position(ichlatLng).title("My Location ");
            myLocationMarker = mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ichlatLng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ichlatLng, 16f));
        }else {
            LatLng updatedIckLatLng = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
            myLocationMarker.setPosition(updatedIckLatLng);
        }

        Intent intent = getIntent();
        String locationString = intent.getStringExtra("Bus_number");

        if (!locationString.isEmpty()) {
            String[] coordinates = locationString.split(","); // Assuming format: "latitude,longitude"
            if (coordinates.length == 2) {

                Log.d("LocationString", locationString);
                destinationLatitude = Double.parseDouble(coordinates[0]);
                destinationLongitude = Double.parseDouble(coordinates[1]);
                Log.d("DestinationCoordinates", "Lat: " + destinationLatitude + ", Long: " + destinationLongitude);

            } else {
                Toast.makeText(TrackingBusRealTime.this, "Invalid location format", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(TrackingBusRealTime.this, "Please enter location", Toast.LENGTH_SHORT).show();
        }

        // Add a marker for destination location
//        destinationLocation = new LatLng(destinationLatitude, destinationLongitude);
        destinationLocation = new LatLng(16.6825694, 74.4704004);
        mMap.addMarker(new com.google.android.gms.maps.model.MarkerOptions().position(destinationLocation).title("Bus Location"));

        Log.i("XOXO",""+currentLocation.getLatitude()+" "+currentLocation.getLongitude());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == FINE_PERMISSION_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }else{
                Toast.makeText(this, "Location permission is denied, please allow the premission", Toast.LENGTH_SHORT).show();
            }
        }
    }


}