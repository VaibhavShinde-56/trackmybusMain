




package com.example.trackmybusmain.Common.TicketBooking;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.Activity;
        import android.app.TimePickerDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TimePicker;
        import android.widget.Toast;

        import com.example.trackmybusmain.Common.HomePage;
        import com.example.trackmybusmain.R;

        import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {
    Button bookTicket ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bookTicket = findViewById(R.id.btnbookTicket);

        bookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                Toast.makeText(getApplicationContext(), "Ticket booking successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }



    public void openAcitivity(){
        Intent intent = new Intent(this, HomePage.class);
        Toast.makeText(this, "Ticket booking successful", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}