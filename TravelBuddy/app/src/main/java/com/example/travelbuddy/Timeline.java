package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;

import com.baoyachi.stepview.VerticalStepView;

import java.util.ArrayList;
import java.util.List;

public class Timeline extends AppCompatActivity {
    VerticalStepView verticalStepView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        verticalStepView = findViewById(R.id.verticalStepView);


        List<String> sources = new ArrayList<>();
        sources.add("Badrinath");
        sources.add("Himalayan Saro Resort");
        sources.add("Niti Valley");
        sources.add("Mishra Restaurant");
        sources.add("Kedarnath");
        sources.add("Kedar River Retreat");
        sources.add("Gangotri");
        sources.add("Himalayan Sadan");
        sources.add("Shiva Restaurant");
        sources.add("Yamunotri");
        sources.add("Dayara resort");
        sources.add("Kharsali");
        sources.add("Rana House Yamuna View");




        verticalStepView.setStepsViewIndicatorComplectingPosition(sources.size()-9)
                .setTextSize(16)
                .reverseDraw(false)
                .setStepViewTexts(sources)
                .setLinePaddingProportion(0.85f)
                .setStepsViewIndicatorCompletedLineColor(Color.parseColor("#FFFF00"))
                .setStepViewUnComplectedTextColor(Color.parseColor("#F0f0f0"))
                .setStepViewComplectedTextColor(ContextCompat.getColor(this,R.color.purple_200))
                .setStepsViewIndicatorUnCompletedLineColor(Color.parseColor("#FFFFF6"))
                .setStepViewComplectedTextColor(Color.parseColor("#FFFF23"))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, com.baoyachi.stepview.R.drawable.attention))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, com.baoyachi.stepview.R.drawable.complted))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, com.baoyachi.stepview.R.drawable.default_icon));


    }
}