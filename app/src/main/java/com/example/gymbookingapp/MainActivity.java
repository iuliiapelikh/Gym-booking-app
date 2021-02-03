package com.example.gymbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity<i> extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        final Spinner nameSpinner = (Spinner) findViewById(R.id.spinner_name);
        final ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gym_names));
        nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nameSpinner.setAdapter(nameAdapter);

        final Spinner locationSpinner = (Spinner) findViewById(R.id.spinner_location);
        final Button button_choose = (Button) findViewById(R.id.button_choose);

        nameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {
                if (i == 0) {
                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.none_chosen));
                    locationSpinner.setAdapter(locationAdapter);

                } else if (i == 1) {
                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.hone_locations));
                    locationSpinner.setAdapter(locationAdapter);
                } else if (i == 2) {
                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.goodlife_locations));
                    locationSpinner.setAdapter(locationAdapter);
                } else if (i == 3) {
                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.equinox_locations));
                    locationSpinner.setAdapter(locationAdapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        button_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(nameSpinner.getSelectedItem()).equals("--Select the gym--") == true) {
                    Toast.makeText(getApplicationContext(), "Please select the gym to proceed", Toast.LENGTH_SHORT).show();
                }
                else if (String.valueOf(nameSpinner.getSelectedItem()).equals("--Select your gym--") == false
                        & String.valueOf(locationSpinner.getSelectedItem()).equals("--Select the location--") == true) {
                    Toast.makeText(getApplicationContext(), "Please select the location to proceed", Toast.LENGTH_SHORT).show();
                }
                else {
                    name.name = String.valueOf(nameSpinner.getSelectedItem());
                    location.location = String.valueOf(locationSpinner.getSelectedItem());

                    Intent intent1 = new Intent(MainActivity.this, activity_choose_date.class);
                    startActivity(intent1);
                }
            }
        });
    }
}