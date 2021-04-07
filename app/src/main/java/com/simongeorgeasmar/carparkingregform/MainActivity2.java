package com.simongeorgeasmar.carparkingregform;
//Simon George Asmar 1162643
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String brand = intent.getStringExtra("BRAND");
        String name = intent.getStringExtra("NAME");
        String phone = intent.getStringExtra("PHONE");
        String email = intent.getStringExtra("EMAIL");
        String plate = intent.getStringExtra("PLATE");
        String year = intent.getStringExtra("YEAR");
        String color = intent.getStringExtra("COLOR");
        Boolean haspasscode = intent.getBooleanExtra("HASPASSCODE", false);
        String passcode = "";
        if (haspasscode){
            passcode = intent.getStringExtra("PASSCODE");
        }


        TextView txt = findViewById(R.id.textView2);
        String summary = "Driver's Info\nName: " +name +"\nPhone: " +phone +"\nEmail: " +email +"\n\n Car's Info\n" +"License Plate: " +plate +"\nBrand: " +brand +"\nModel Year: " +year +"\n";
        if (haspasscode){
            summary+="Pass Code: " +passcode;
        } else {
            summary+="Car has no pass code.";
        }

        txt.setText(summary);
    }
}