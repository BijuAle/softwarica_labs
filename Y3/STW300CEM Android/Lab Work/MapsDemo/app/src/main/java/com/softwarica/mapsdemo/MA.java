package com.softwarica.mapsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MA extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;



    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        //Add Marker
        LatLng kathmandu = new LatLng(27.7172, 85.3240);
        googleMap.addMarker(new MarkerOptions()
                .position(kathmandu)
                .title("I am Kathmandu"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(kathmandu));
    }
}
