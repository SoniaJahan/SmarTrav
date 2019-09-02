package com.example.smartrav.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartrav.R;

public class ViewTourActivity extends AppCompatActivity {

    private String tourId,tourName,tourPlace,startDate,endDate,description;
    private TextView tourNameTV, tourPlaceTV,tourStartTV , tourEndTV, tourDescriptionTV ;
    private Button editBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tour);

        tourNameTV = findViewById(R.id.tourNameTV);
        tourPlaceTV = findViewById(R.id.tourPlaceTV);
        tourStartTV = findViewById(R.id.tourStartTV);
        tourEndTV = findViewById(R.id.tourEndTV);
        tourDescriptionTV = findViewById(R.id.tourDescriptionTV);
        editBtn = findViewById(R.id.editBtn);
        deleteBtn = findViewById(R.id.deleteBTN);

        if(getIntent().getExtras() !=null){
            tourName = getIntent().getStringExtra("tourName");
            tourPlace = getIntent().getStringExtra("tourPlace");
            startDate = getIntent().getStringExtra("startDate");
            endDate = getIntent().getStringExtra("endDate");
            description = getIntent().getStringExtra("description");
            tourNameTV.setText(tourName);
            tourPlaceTV.setText(tourPlace);
            tourStartTV.setText(startDate);
            tourEndTV.setText(endDate);
            tourDescriptionTV.setText(description);

        }
    }
}
