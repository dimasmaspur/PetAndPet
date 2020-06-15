package com.example.petandpet;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList= new ArrayList<LatLng>();
    ArrayList<String> nama = new ArrayList<>();

    LatLng lokasi1 = new LatLng(-6.331009,106.7072983);
    LatLng lokasi2 = new LatLng(-6.3297086,106.7082839);
    LatLng lokasi3 = new LatLng(-6.3337947,106.7087925);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        arrayList.add(lokasi1);
        arrayList.add(lokasi2);
        arrayList.add(lokasi3);
        nama.add("Petshop Pamulang");
        nama.add("Tricats pet shop");
        nama.add("Andrie Vet Clinic");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        for(int i=0; i<arrayList.size();i++){
//                    mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(title.get(i)));


            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(nama.get(i)));
//                    mMap.animateCamera(CameraUpdateFactory.zoomTo(26));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arrayList.get(i), 16));
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.getUiSettings().setCompassEnabled(true);


        }
    }
}
