package com.latencot.platoon.ui.profile.manageprojects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;
import com.latencot.platoon.ui.profile.manageboats.AddBoat;
import com.latencot.platoon.ui.profile.manageprojects.adapters.BoatAdapter;
import com.latencot.platoon.ui.profile.manageprojects.adapters.BoatAdapter2;
import com.latencot.platoon.ui.profile.manageprojects.adapters.BoatItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class AddBoatToProject extends AppCompatActivity {
    RecyclerView rv_boats;
    BoatItems boatItems[];
//    BigInteger serial_id;
    CompanyLoginData loginData;
    BigInteger project_id;
    SharedIt shr;
    int RESULT_OK = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat_to_project);
        rv_boats = findViewById(R.id.aabtp_boatsrecycler);
        shr = new SharedIt(this);
//        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        loginData = shr.getCompanyLoginData();
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        project_id = (BigInteger) extras.get(SharedItHelper.project_id);
        getUnmappedBoats();
    }
    @Override
    public void finish() {
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent); //By not passing the intent in the result, the calling activity will get null data.
        super.finish();
    }
    public void getUnmappedBoats(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getUnmappedBoats(loginData.getSerial_id());

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
                    Toast.makeText(AddBoatToProject.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showBoatList(){
        BoatAdapter2 boatAdapter = new BoatAdapter2(this, boatItems);
        rv_boats.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv_boats.setAdapter(boatAdapter);
        rv_boats.setItemAnimator(new DefaultItemAnimator());
    }
    public void addBoat(BigInteger regno){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .addBoatToProject(regno, project_id);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                        if(!error){
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
