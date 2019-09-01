package com.example.smartrav.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartrav.Class.Trip;
import com.example.smartrav.R;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private List<Trip> tripList;
    private Context context;

    public TripAdapter(List<Trip> tripList, Context context) {
        this.tripList = tripList;
        this.context = context;
    }

    @NonNull
    @Override
    public TripAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_trips,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripAdapter.ViewHolder holder, int position) {

        Trip currentTrip = tripList.get(position);

        holder.tNameET.setText(currentTrip.getTourName());
        holder.tPlaceET.setText(currentTrip.getTourPlace());
        holder.openStartDatePickerBtn.setText(currentTrip.getStartDate());
        holder.openEndDatePickerBtn.setText(currentTrip.getEndDate());
        holder.tDescriptionET.setText(currentTrip.getDescription());



    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText tNameET, tPlaceET,tDescriptionET;
        private Button saveTripBtn, openStartDatePickerBtn, openEndDatePickerBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tNameET =itemView.findViewById(R.id.tNameET);
            tPlaceET = itemView.findViewById(R.id.tPlaceET);
            openEndDatePickerBtn = itemView.findViewById(R.id.openEndTimePickerBtn);
            openStartDatePickerBtn = itemView.findViewById(R.id.openStartDatePickerBtn);
            tDescriptionET = itemView.findViewById(R.id.tDescriptionET);
            saveTripBtn = itemView.findViewById(R.id.saveTripBtn);



        }


    }
}
