package com.example.chengen.crowdsafetyalerts;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    private double la,lon;
    private static String target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void getMyLocation()
    {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria crit = new Criteria();
        crit.setAccuracy(Criteria.ACCURACY_FINE);
        String PROVIDER = locationManager.getBestProvider(crit, true);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager.getLastKnownLocation(PROVIDER);
        showLocation(location);
    }
    public void showLocation(Location location)
    {
        if(location==null)
        {
            Toast.makeText(getApplicationContext(), "Unknow Location", Toast.LENGTH_SHORT).show();
        }else{
            lon=location.getLongitude();
            la=location.getLatitude();
        }
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
        getMyLocation();
        Toast.makeText(getApplicationContext(),la+" "+lon,Toast.LENGTH_SHORT).show();
        LatLng coordinate = new LatLng(la,lon);
        MarkerOptions options = new MarkerOptions().draggable(true).position(coordinate).title("Default marker");
        mMap.addMarker(options);
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Geocoder geo = new Geocoder(MapsActivity.this);
                List<Address> list = null;
                LatLng ll = marker.getPosition();
                try {
                    list = geo.getFromLocation(ll.latitude, ll.longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                Address add = list.get(0);
                marker.setTitle(add.getLocality());
                marker.setSnippet(add.getCountryName());
                marker.showInfoWindow();
                target = ll.toString();
            }
        });
    }
    public static  String getTarget()
    {return target;}

}
