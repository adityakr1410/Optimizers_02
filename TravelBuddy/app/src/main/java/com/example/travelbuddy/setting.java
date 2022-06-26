package com.example.travelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.travelbuddy.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class setting extends AppCompatActivity {
TextView signou;
TextView feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        signou = findViewById(R.id.signout);
        feedback = findViewById(R.id.feedback);
        signou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(setting.this,Login.class);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(setting.this,feedback.class);
                startActivity(intent);

            }
        });
    }
}