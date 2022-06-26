package com.example.travelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class feedback extends AppCompatActivity {
    EditText name;

    EditText feedback;
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        feedback = findViewById(R.id.feedback);
        Submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("Message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String("Xyz@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                i.putExtra(Intent.EXTRA_TEXT, "Name" + name.getText() + "\n Message" + feedback.getText());
                try {
                    startActivity(Intent.createChooser(i, "please select Email"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(feedback.this, "Error in getting Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}