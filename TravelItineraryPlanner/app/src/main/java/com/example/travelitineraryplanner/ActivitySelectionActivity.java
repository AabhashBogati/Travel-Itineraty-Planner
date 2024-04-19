package com.example.travelitineraryplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySelectionActivity extends AppCompatActivity {
    CheckBox hikingCheckBox, sightseeingCheckBox, swimmingCheckBox;
    Button finishButton;
    TextView destinationTextView, datesTextView;

    String destination;
    String startDate;
    String endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_activity);

        // Initialize views
        hikingCheckBox = findViewById(R.id.activity_hiking_checkbox);
        sightseeingCheckBox = findViewById(R.id.activity_sightseeing_checkbox);
        swimmingCheckBox = findViewById(R.id.activity_swimming_checkbox);
        finishButton = findViewById(R.id.finish_button);
        destinationTextView = findViewById(R.id.destination_text_view);
        datesTextView = findViewById(R.id.dates_text_view);

        // Get data from previous activities
        Intent intent = getIntent();
        destination = intent.getStringExtra("destination");
        startDate = intent.getStringExtra("start_date");
        endDate = intent.getStringExtra("end_date");

        // Set destination and dates in TextViews
        destinationTextView.setText("Destination: " + destination);
        datesTextView.setText("Dates: " + startDate + " - " + endDate);

        // Handle finish button click
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected activities
                StringBuilder selectedActivities = new StringBuilder();
                if (hikingCheckBox.isChecked()) {
                    selectedActivities.append("Hiking, ");
                }
                if (sightseeingCheckBox.isChecked()) {
                    selectedActivities.append("Sightseeing, ");
                }
                if (swimmingCheckBox.isChecked()) {
                    selectedActivities.append("Swimming, ");
                }

                // Remove trailing comma and space
                if (selectedActivities.length() > 0) {
                    selectedActivities.setLength(selectedActivities.length() - 2);
                }

                // Show summary dialog
                showSummaryDialog(selectedActivities.toString());
            }
        });
    }

    private void showSummaryDialog(String activities) {
        // Create and show a summary dialog
        SummaryDialog dialog = new SummaryDialog(this, destination, startDate, endDate, activities);
        dialog.show();
    }
}
