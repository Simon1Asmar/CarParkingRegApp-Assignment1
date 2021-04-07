package com.simongeorgeasmar.carparkingregform;
//Simon George Asmar 1162643
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText edtName;
    EditText edtPhone;
    EditText edtEmail;
    EditText edtPlate;
    EditText edtYear;
    EditText edtColor;
    Switch switchPasscode;
    EditText edtPasscode;
    LinearLayout layoutPasscode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        spinner = findViewById(R.id.spnBrand);
        populateSpinner();
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtPlate = findViewById(R.id.edtPlate);
        edtYear = findViewById(R.id.edtYear);
        edtColor = findViewById(R.id.edtColor);
        switchPasscode = findViewById(R.id.switchPasscode);
        edtPasscode = findViewById(R.id.edtPasscode);
        layoutPasscode = findViewById(R.id.layoutPasscode);

    }

    private void populateSpinner() {
        ArrayList<String> brands = new ArrayList<String>();
        brands.add("Rolls Royce");
        brands.add("Ferrari");
        brands.add("Lamborghini");
        brands.add("Bugatti");
        brands.add("Chevrolet");
        brands.add("Toyota");
        brands.add("BMW");
        brands.add("Mercedes");
        brands.add("GMC");
        brands.add("Jaguar");
        brands.add("Kia");
        brands.add("Mazda");
        brands.add("Honda");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brands);

        spinner.setAdapter(adapter);
    }

    public void btnSave_onClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);

        String brand = spinner.getSelectedItem().toString();
        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        String email = edtEmail.getText().toString();
        String plate = edtPlate.getText().toString();
        String year = edtYear.getText().toString();
        String color = edtColor.getText().toString();

        Boolean hasPasscode = switchPasscode.isChecked();
        if(switchPasscode.isChecked()){
            String passcode = edtPasscode.getText().toString();
            intent.putExtra("PASSCODE", passcode);
        }


        intent.putExtra("BRAND", brand);
        intent.putExtra("NAME", name);
        intent.putExtra("PHONE", phone);
        intent.putExtra("EMAIL", email);
        intent.putExtra("PLATE", plate);
        intent.putExtra("YEAR", year);
        intent.putExtra("COLOR", color);
        intent.putExtra("HASPASSCODE", hasPasscode);

        startActivity(intent);

    }

    public void switchPasscode_onClick(View view) {
        if (switchPasscode.isChecked()){
            layoutPasscode.setVisibility(View.VISIBLE);
            Toast.makeText(this, "PassCode ON", Toast.LENGTH_SHORT).show();
        } else {
            layoutPasscode.setVisibility(View.GONE);
            Toast.makeText(this, "PassCode OFF", Toast.LENGTH_SHORT).show();
        }
    }
}