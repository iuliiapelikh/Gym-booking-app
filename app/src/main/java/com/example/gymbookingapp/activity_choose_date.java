package com.example.gymbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class activity_choose_date extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);

        final Spinner timeSpinner = (Spinner) findViewById(R.id.spinner_time);
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(activity_choose_date.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.time));
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd");
        date.date = (Date)calendar.getTime();
        date1.date1 = sdf.format(date.date);


        Button button_confirm = (Button) findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(timeSpinner.getSelectedItem()).equals("--Select the time--") == true) {
                    Toast.makeText(getApplicationContext(), "Please choose the time to proceed",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent2 = new Intent(activity_choose_date.this, activity_confirmation.class);
                    startActivity(intent2);
                    time.time = String.valueOf(timeSpinner.getSelectedItem());
                }
            }
        });
    }
}