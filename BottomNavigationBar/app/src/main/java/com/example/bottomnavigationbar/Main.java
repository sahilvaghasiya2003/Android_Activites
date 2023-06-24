package com.example.bottomnavigationbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Main extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    public static final int id=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottonav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                if (item.getItemId()==R.id.home_menu){
                    fragment = new Home();
                    Log.e("Test", "home_menu");
                }else if (item.getItemId()==R.id.share){
                    fragment = new Share();
                    Log.e("Test", "share");
                }else if (item.getItemId()==R.id.profile){
                    fragment = new Profile();
                    Log.e("Test", "profile");
                }
                if (fragment != null) {
                    loadFragment(fragment);
                }

                return false;
            }
        });
        loadFragment(new Home());

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        /*switch (item.getItemId()){
            case R.id.home:
                fragment = new Home();
                break;
            case R.id.share:
                fragment = new Share();
                break;
            case R.id.profile:
                fragment = new Profile();
                break;

        }*/
        if (fragment != null) {
            loadFragment(fragment);
        }

        return true;
    }

    void loadFragment(Fragment fragment) {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relative, fragment).commit();
    }


}