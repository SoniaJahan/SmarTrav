package com.example.smartrav.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartrav.Activity.MainActivity;
import com.example.smartrav.Activity.ViewTourActivity;
import com.example.smartrav.Class.Trip;
import com.example.smartrav.R;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private ArrayList<Trip> tripList;
    private Context context;

    public TripAdapter(ArrayList<Trip> tripList, Context context) {
        this.tripList = tripList;
        this.context = context;
    }

    public TripAdapter() {
    }

    @NonNull
    @Override
    public TripAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_trips,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripAdapter.ViewHolder holder, int position) {

        final Trip trip = tripList.get(position);

        holder.tourNameTV.setText(trip.getTourName());

        holder.detailsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewTourActivity.class);
                intent.putExtra("tourName",trip.getTourName());
                intent.putExtra("tourPlace",trip.getTourPlace());
                intent.putExtra("startDate",trip.getStartDate());
                intent.putExtra("endDate",trip.getEndDate());
                intent.putExtra("description",trip.getDescription());



                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tourNameTV;
        private Button detailsBTN;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tourNameTV = itemView.findViewById(R.id.tourNameTV);
            detailsBTN = itemView.findViewById(R.id.detailsBTN);





        }


    }
}
