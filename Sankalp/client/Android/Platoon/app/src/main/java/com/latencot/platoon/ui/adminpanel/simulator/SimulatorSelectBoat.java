package com.latencot.platoon.ui.adminpanel.simulator;

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
import android.view.View;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.profile.manageboats.AddBoat;
import com.latencot.platoon.ui.profile.manageboats.CompanyBoatsList;
import com.latencot.platoon.ui.profile.manageboats.adapters.BoatAdapter;
import com.latencot.platoon.ui.profile.manageboats.adapters.BoatItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class SimulatorSelectBoat extends AppCompatActivity {
    private static final String TAG = "SimulatorSelectBoat";
    BoatItems boatItems[];
    BigInteger serial_id, project_id;
    SharedIt shr;
    RecyclerView rv_boat_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator_select_boat);
        shr = new SharedIt(this);
        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        rv_boat_list = findViewById(R.id.assb_boatrecycler);
        rv_boat_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        project_id = (BigInteger) (extras.get(SharedItHelper.project_id));
        getBoats();
    }
    public void getBoats(){
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
                            JSONArray boatsjsonarray = data.getJSONArray("data");
                            for(int i = 0; i < boatsjsonarray.length(); i++){
                                JSONObject boatsjsonobject = boatsjsonarray.getJSONObject(i);
                                BigInteger boat_id = BigInteger.valueOf(boatsjsonobject.getLong("serial_id"));
                                BigInteger registration_no = BigInteger.valueOf(boatsjsonobject.getLong("registration_number"));
                                String petname = boatsjsonobject.getString("pet_name");
                                String type = boatsjsonobject.getString("type");
                                int verified = boatsjsonobject.getInt("verified");
                                Log.d(TAG, "onResponse: " + boat_id + " : " + registration_no);
                                BoatItems boatItems = new BoatItems(verified, petname, type, registration_no, serial_id);
                                boatsarraylist.add(boatItems);
                            }
                            BoatItems[] items = boatsarraylist.toArray(new BoatItems[boatsarraylist.size()]);
                            boatItems = items;
                            showBoatsList();
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
    public void showBoatsList(){
        BoatAdapter boatAdapter = new BoatAdapter(this, boatItems);
        rv_boat_list.setAdapter(boatAdapter);
        rv_boat_list.setItemAnimator(new DefaultItemAnimator());
    }
}
