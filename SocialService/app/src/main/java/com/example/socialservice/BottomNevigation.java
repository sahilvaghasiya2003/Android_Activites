package com.example.socialservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNevigation extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nevigation);
        getSupportActionBar().hide();


        bottomNavigationView = findViewById(R.id.bottonav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                if(item.getItemId() == R.id.home){
                    fragment =new HomePage();
                } else if (item.getItemId() == R.id.save) {
                    fragment =new SavePage();
                }else if (item.getItemId() == R.id.add) {
                    fragment =new AddPage();
                }else if (item.getItemId() == R.id.message) {
                    fragment =new MessagePage();
                }else if (item.getItemId() == R.id.profile) {
                    fragment =new ProfilePage();
                }
                if (fragment != null) {
                    loadFragment(fragment);
                }
                return false;
            }
        });
        loadFragment(new HomePage());


    }


    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item and false if the item should not be
     * selected. Consider setting non-selectable items as disabled preemptively to make them
     * appear non-interactive.
     */
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

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frag, fragment).commit();

    }
}