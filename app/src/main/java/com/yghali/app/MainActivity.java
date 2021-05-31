package com.yghali.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.menu);
       bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
       openFragment(calendar.newInstance("", ""));

    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new  BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_timetable:
                    openFragment(timetable.newInstance("", ""));
                    return true;
                case R.id.navigation_profil:
                    openFragment(profil.newInstance("", ""));
                    return true;
                case R.id.navigation_note:
                   openFragment(note.newInstance("", ""));
                    return true;
                case R.id.navigation_calendar:
                  openFragment(calendar.newInstance("", ""));
                    return true;


            }
            return false;
        }
    };

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}