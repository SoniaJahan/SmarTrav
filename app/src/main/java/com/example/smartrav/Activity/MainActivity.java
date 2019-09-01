package com.example.smartrav.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.smartrav.Fragment.MomentsFragment;
import com.example.smartrav.R;
import com.example.smartrav.Fragment.TripsFragment;
import com.example.smartrav.Fragment.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView nav_view;
    private DrawerLayout drawerLayout;
    private NavigationView navview;
    private FloatingActionButton fab;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_view = findViewById(R.id.nav_view);
        replaceFragment(new TripsFragment());

        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddTourActivity.class));
            }
        });




    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameL, fragment);
        ft.commit();
    }


}
