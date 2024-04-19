package com.example.travelitineraryplanner;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryDialog extends Dialog {
    private String destination;
    private String startDate;
    private String endDate;
    private String activities;

    public SummaryDialog(Context context, String destination, String startDate, String endDate, String activities) {
        super(context);
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activities = activities;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_summary);

        // Initialize TextViews in the dialog layout
        TextView destinationTextView = findViewById(R.id.summary_destination_text_view);
        TextView datesTextView = findViewById(R.id.summary_dates_text_view);
        TextView activitiesTextView = findViewById(R.id.summary_activities_text_view);

        // Set text for TextViews
        destinationTextView.setText("Destination: " + destination);
        datesTextView.setText("Dates: " + startDate + " - " + endDate);
        activitiesTextView.setText("Activities: " + activities);
    }
}
