package com.latencot.platoon.ui.profile.manageprojects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.profile.manageboats.BoatDetails;
import com.latencot.platoon.ui.profile.manageboats.CompanyBoatsList;
import com.latencot.platoon.ui.profile.manageprojects.adapters.BoatAdapter;
import com.latencot.platoon.ui.profile.manageprojects.adapters.BoatItems;
import com.latencot.platoon.ui.profile.manageprojects.adapters.ProjectItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ProjectDetails extends AppCompatActivity implements OnMapReadyCallback {
    SharedIt shr;
    TextView tv_name, tv_description, tv_anonymous, tv_id;
    BigInteger serial_id, project_id;
    Button bt_delete;
    String name, description;
    int isanonymous;
    BoatItems boatItems[];
    RecyclerView rv_addedboatlist;
    //All Related To Maps

    private static final String TAG = "MapsNavActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 8f;
    private boolean mLocationPermissionGranted = false;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleMap mMap;
    private Marker marker;
    private static double bigLatitude, bigLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);

        shr = new SharedIt(this);
        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        rv_addedboatlist = findViewById(R.id.apd_boatrecycler);
        rv_addedboatlist.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_addedboatlist.setItemAnimator(new DefaultItemAnimator());

        tv_name = findViewById(R.id.apd_projectname);
        tv_description = findViewById(R.id.apd_projectdescription);
        tv_anonymous = findViewById(R.id.apd_projectisanonymous);
        tv_id = findViewById(R.id.apd_projectid);
        bt_delete = findViewById(R.id.apd_delete);

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProject();
            }
        });

        initMap();
    }
    public void getProjectDetails(){

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getSpecificProjects(project_id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        Toast.makeText(ProjectDetails.this, error_message, Toast.LENGTH_SHORT).show();
                        if(!error){
                            JSONObject data = message.getJSONObject("data");
                            project_id = new BigInteger(data.getString("project_id"));
                            name = data.getString("project_name");
                            description = data.getString("project_description");
                            isanonymous = data.getInt("is_anonymous");
                            Double location_lat = Double.parseDouble(data.getString("location_lat"));
                            Double location_lng = Double.parseDouble(data.getString("location_lng"));
                            LatLng latLng = new LatLng(location_lat, location_lng);
                            addMarker(latLng, name);
                            moveCamera(latLng, DEFAULT_ZOOM, "");
                            tv_id.setText(project_id.toString());
                            tv_name.setText(name);
                            tv_description.setText(description);
                            if(isanonymous == 0){
                                tv_anonymous.setText("Yes");
                            }else{
                                tv_anonymous.setText("No");
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ProjectDetails.this, ProjectList.class);
                            startActivity(i);
                            finishAffinity();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    } catch (NumberFormatException n){
                        Toast.makeText(ProjectDetails.this, ErrorMessages.error_parsing_location, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ProjectDetails.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getAssociatedBoats(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAssociatedBoats(project_id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject data = new JSONObject(response.body().string());
                        boolean error = data.getBoolean("error");
                        String error_message = data.getString("error_message");
                        Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                        if(!error){
                            ArrayList<BoatItems> boatsarraylist = new ArrayList<BoatItems>();
                            JSONArray boatjsonarray = data.getJSONArray("data");
                            for(int i = 0; i < boatjsonarray.length(); i++){
                                JSONObject boatsjsonobject = boatjsonarray.getJSONObject(i);
                                BigInteger boat_id = BigInteger.valueOf(boatsjsonobject.getLong("serial_id"));
                                String boat_name = boatsjsonobject.getString("pet_name");
                                String boat_type = boatsjsonobject.getString("type");
                                Log.d(TAG, "onResponse: " + project_id + " : " + boat_type);
                                BoatItems boatItem = new BoatItems(boat_id, boat_name, boat_type);
                                boatsarraylist.add(boatItem);
                            }
                            BoatItems[] items = boatsarraylist.toArray(new BoatItems[boatsarraylist.size()]);
                            boatItems = items;
                            showBoatList();
                        }else{
                            Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ProjectDetails.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showBoatList(){
        BoatAdapter boatAdapter = new BoatAdapter(this, boatItems);
        rv_addedboatlist.setAdapter(boatAdapter);
    }
    public void deleteProject(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .deleteProject(project_id);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        if(!error){
                            Intent i = new Intent(ProjectDetails.this, ProjectList.class);
                            startActivity(i);
                            finishAffinity();
                        }else{
                            Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation : Getting Device Current Location");
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (mLocationPermissionGranted) {
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "OnComplete : found location");
                            Location currentLocation = (Location) task.getResult();
                            LatLng latLng;
                            if (currentLocation != null) {
                                latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
                                moveCamera(latLng, DEFAULT_ZOOM, "Current Location");
                            }
                        } else {
                            Log.d(TAG, "OnComplete : current location is null");
                            Toast.makeText(getApplicationContext(), "Location Unknown", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e(TAG, "getDeviceLocation : SecurityException " + e.getMessage());
        }
    }
    private void getLocationPermission() {
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            Log.d(TAG, "onRequestPermissionsResult: permissions failed.");
                            mLocationPermissionGranted = false;
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permissions granted.");
                    mLocationPermissionGranted = true;
                    initMap();
                }
            }
        }
    }
    public void initMap(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.apd_map);
        mapFragment.getMapAsync(this);
    }
    private void moveCamera(LatLng latLng, float zoom, String title) {
        Log.d(TAG, "moveCamera : Moving the Camera to Lat : " + latLng.latitude + " lng : " + latLng.longitude);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }
    public void addMarker(LatLng latLng, String name){
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title(name);
        mMap.addMarker(markerOptions);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnCameraIdleListener(onCameraIdleListener);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if(extras.getString(SharedItHelper.project_id) != null) {
            project_id = new BigInteger(extras.getString(SharedItHelper.project_id));
            getProjectDetails();
            getAssociatedBoats();
        }

    }
    public GoogleMap.OnCameraIdleListener onCameraIdleListener = new GoogleMap.OnCameraIdleListener() {
        @Override
        public void onCameraIdle() {
        Log.d(TAG, "moveCameraonIdle : Triggered");
        }
    };
}
