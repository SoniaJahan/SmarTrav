package com.example.smartrav.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartrav.R;
import com.example.smartrav.Class.Trip;
import com.example.smartrav.Adapter.TripAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddTourActivity extends AppCompatActivity {

    private List<Trip> tripList;
    private TripAdapter tripAdapter;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private EditText tNameET, tPlaceET,tDescriptionET;
    private Button saveTripBtn, openStartDatePickerBtn, openEndDatePickerBtn;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tour);

        init();

        userId = firebaseAuth.getCurrentUser().getUid();

        openStartDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openStartDatePicker();
            }
        });

        openEndDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                openEndDatePicker();
            }
        });

        saveTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tName = tNameET.getText().toString();
                String tPlace = tPlaceET.getText().toString();
                String tDescription = tDescriptionET.getText().toString();
                String startDate = openStartDatePickerBtn.getText().toString();
                String endDate = openEndDatePickerBtn.getText().toString();

                addTrip(tName,tPlace,tDescription,startDate,endDate);
            }
        });
    }

    private void openEndDatePicker() {

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;

                String currentDate = year + "/" + month + "/" + day;

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

                Date date = null;

                try {
                    date = simpleDateFormat.parse(currentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                openEndDatePickerBtn.setText(simpleDateFormat.format(date));

            }
        };

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, year, month, 1);
        datePickerDialog.show();
    }

    private void openStartDatePicker() {
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;

                String currentDate = year + "/" + month + "/" + day;

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

                Date date = null;

                try {
                    date = simpleDateFormat.parse(currentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                openStartDatePickerBtn.setText(simpleDateFormat.format(date));

            }
        };

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, year, month, 1);
        datePickerDialog.show();
    }

    private void addTrip(String tName, String tPlace, String tDescription, String startDate, String endDate) {
        DatabaseReference tripRef = databaseReference.child("users").child(userId).child("trip");

        String tripTd = tripRef.push().getKey();
        Trip trip = new Trip(tName,tPlace,tDescription,startDate,endDate);


        tripRef.child(tripTd).setValue(trip).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(AddTourActivity.this, "Added", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddTourActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void init() {

        tripList = new ArrayList<>();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        tNameET = findViewById(R.id.tNameET);
        tPlaceET = findViewById(R.id.tPlaceET);
        openEndDatePickerBtn = findViewById(R.id.openEndTimePickerBtn);
        openStartDatePickerBtn = findViewById(R.id.openStartDatePickerBtn);
        tDescriptionET = findViewById(R.id.tDescriptionET);
        saveTripBtn = findViewById(R.id.saveTripBtn);
        
        
    }
}
