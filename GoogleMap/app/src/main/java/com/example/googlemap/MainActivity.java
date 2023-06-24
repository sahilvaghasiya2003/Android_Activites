package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
private GoogleMap gmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

                gmap = googleMap;
                LatLng latLng = new LatLng(26.2389, 73.0243);
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("JODHPUR");

                gmap.addMarker(markerOptions);
                gmap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));



            }
        });

    }
}