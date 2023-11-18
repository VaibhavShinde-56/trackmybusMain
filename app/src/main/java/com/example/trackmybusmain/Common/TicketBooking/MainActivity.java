package com.example.trackmybusmain.Common.TicketBooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.trackmybusmain.R;

public class MainActivity extends AppCompatActivity {
    EditText from_locate , to_locate ;
    public static final String EXTRA_NAME = "Loc1" ;
    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        from_locate = findViewById(R.id.from_locat);
        to_locate = findViewById(R.id.to_locat);
        String fromLocation = from_locate.getText().toString();
        String toLocation = to_locate.getText().toString();


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

    }
    public void openActivity() {

        from_locate= findViewById(R.id.from_locat);
        to_locate = findViewById(R.id.to_locat);
        String fromLocation = from_locate.getText().toString();
        String toLocation = to_locate.getText().toString();

        Toast.makeText(this, "Location has Saved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext() , MainActivity2.class);

        startActivity(intent);

    }
}