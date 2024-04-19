package com.example.travelitineraryplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

public class DateSelectionActivity extends AppCompatActivity {
    DatePicker startDatePicker, endDatePicker;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_selection_activity);

        startDatePicker = findViewById(R.id.start_date_picker);
        endDatePicker = findViewById(R.id.end_date_picker);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected start and end dates from DatePickers
                int startDay = startDatePicker.getDayOfMonth();
                int startMonth = startDatePicker.getMonth() + 1; // Month is zero-based
                int startYear = startDatePicker.getYear();

                int endDay = endDatePicker.getDayOfMonth();
                int endMonth = endDatePicker.getMonth() + 1; // Month is zero-based
                int endYear = endDatePicker.getYear();

                // Format dates as strings (e.g., "DD/MM/YYYY")
                String startDate = String.format("%02d/%02d/%04d", startDay, startMonth, startYear);
                String endDate = String.format("%02d/%02d/%04d", endDay, endMonth, endYear);

                // Retrieve destination from previous activity
                Intent intent = getIntent();
                String destination = intent.getStringExtra("destination");

                // Pass destination, start date, and end date to next activity
                Intent nextIntent = new Intent(DateSelectionActivity.this, ActivitySelectionActivity.class);
                nextIntent.putExtra("destination", destination);
                nextIntent.putExtra("start_date", startDate);
                nextIntent.putExtra("end_date", endDate);
                startActivity(nextIntent);
            }
        });
    }
}

