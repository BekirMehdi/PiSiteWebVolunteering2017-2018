package com.example.dell_pc.volunteering;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.dell_pc.volunteering.models.Event;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMarkerClickListener, OnMapReadyCallback , ConnectionCallbacks,
       OnConnectionFailedListener, LocationListener {
    GoogleApiClient mGoogleApiClient;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public String url = "http://10.0.2.2:18080/volunteering-web/rest/Event";
    List<Event> listEvents = new ArrayList<>();

    //private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);
      //  private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
        //private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);

        private Marker mPerth;
    private Marker mPerth1;
    private Marker mPerth2;
    private Marker mPerth3;
    private Marker mPerth4;
        private GoogleMap mMap;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        /** Called when the map is ready. */
        @Override
        public void onMapReady(GoogleMap map) {
            mMap = map;

            // Add some markers to the map, and add a data object to each marker.
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, (String) null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            int count = 0;
                            while (count < response.length()) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(count);
                                    Event event = new
                                            Event(jsonObject.getString("nameEvent"), jsonObject.getString("longitude"), jsonObject.getString("latitude"));

                                    mPerth = mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(event.getLng()),Double.parseDouble(event.getLalt()))).title(event.getNameEvent()));
                                    mPerth.setTag(0);

                                    listEvents.add(event);
                                    count++;


                                }  //end try
                                catch (JSONException e) {
                                    Toast.makeText(MapsActivity.this, "error !!", Toast.LENGTH_SHORT).show();

                                    e.printStackTrace();
                                }
                            }





                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            error.printStackTrace();
                        }
                    });

            Mysingleton.getmInstance(MapsActivity.this).addToREquestQue(jsonArrayRequest);


            // Set a listener for marker click.
            mMap.setOnMarkerClickListener(this);
        }

        /** Called when the user clicks a marker. */
        @Override
        public boolean onMarkerClick(final Marker marker) {

            // Retrieve the data from the marker.
            Integer clickCount = (Integer) marker.getTag();

            // Check if a click count was set, then display the click count.
            if (clickCount != null) {
                clickCount = clickCount + 1;
                marker.setTag(clickCount);
                Toast.makeText(this,
                        marker.getTitle() +
                                " has been clicked " + clickCount + " times.",
                        Toast.LENGTH_SHORT).show();
            }

            // Return false to indicate that we have not consumed the event and that we wish
            // for the default behavior to occur (which is for the camera to move such that the
            // marker is centered and for the marker's info window to open, if it has one).
            return false;
        }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)

                .build();
        mGoogleApiClient.connect();
    }

    public boolean checkPermissions(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);

            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
