package com.example.travelitineraryplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DestinationSelectionActivity extends AppCompatActivity {
    EditText destinationEditText;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_selection_activity);

        destinationEditText = findViewById(R.id.destination_edit_text);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = destinationEditText.getText().toString();
                Intent intent = new Intent(DestinationSelectionActivity.this, DateSelectionActivity.class);
                intent.putExtra("destination", destination);
                startActivity(intent);
            }
        });
    }
}
