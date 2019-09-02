package com.example.smartrav.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.smartrav.Adapter.TripAdapter;
import com.example.smartrav.Class.Trip;
import com.example.smartrav.Fragment.MomentsFragment;
import com.example.smartrav.R;
import com.example.smartrav.Fragment.TripsFragment;
import com.example.smartrav.Fragment.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fab;
    private BottomNavigationView nav_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        replaceFragment(new TripsFragment());

        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddTourActivity.class));
            }
        });


    }

    private void init() {

        nav_view = findViewById(R.id.nav_view);
        fab = findViewById(R.id.fab);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_trips:
                    replaceFragment(new TripsFragment());
                    return true;
                case R.id.navigation_moments:
                    replaceFragment(new MomentsFragment());
                    return true;
                case R.id.navigation_wallet:
                    replaceFragment(new WalletFragment());
                    return true;
            }
            return false;
        }
    };


    private void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameL,fragment);
        ft.commit();

    }
}

