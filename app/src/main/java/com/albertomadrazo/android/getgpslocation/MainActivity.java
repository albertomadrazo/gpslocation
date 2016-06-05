package com.albertomadrazo.android.getgpslocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btnShowLocation;

        final GPSTracker[] gps = new GPSTracker[1];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLocation = (Button) findViewById(R.id.show_location);
        btnShowLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gps[0] = new GPSTracker(MainActivity.this);

                if(gps[0].canGetLocation){
                    double latitude = gps[0].getLatitude();
                    double longitude = gps[0].getLongitude();

                    Toast.makeText(getApplicationContext(),
                            "Your location is -\nLat: " + latitude + "\nLong: "
                                    + longitude, Toast.LENGTH_LONG).show();
                } else{
                    gps[0].showSettingsAlert();
                }
            }
        });
    }
}
