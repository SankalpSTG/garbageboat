package com.latencot.platoon.ui.profile.manageboats;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.MainActivity;
import com.latencot.platoon.ui.authentication.LoginActivity;
import com.latencot.platoon.ui.profile.manageboats.adapters.BoatAdapter;
import com.latencot.platoon.ui.profile.manageboats.adapters.BoatItems;
import com.latencot.platoon.ui.userpanel.SubmitProblem;
import com.latencot.platoon.ui.userpanel.adapters.ProblemAdapter;
import com.latencot.platoon.ui.userpanel.adapters.ProblemItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class CompanyBoatsList extends AppCompatActivity {
    private static final String TAG = "CompanyBoatsList";
    FloatingActionButton bt_add;
    BoatItems boatItems[];
//    BigInteger serial_id;
    CompanyLoginData loginData;
    SharedIt shr;
    RecyclerView rv_boat_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_boats_list);

        shr = new SharedIt(this);
//        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        if(shr.getCompanyLoginData() != null){
            loginData = shr.getCompanyLoginData();
        }else{
            Intent i = new Intent(CompanyBoatsList.this, LoginActivity.class);
            startActivity(i);
        }
        rv_boat_list = findViewById(R.id.acbl_boatrecycler);
        rv_boat_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        getBoats();

        bt_add = findViewById(R.id.acbl_addbutton);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CompanyBoatsList.this, AddBoat.class);
                startActivity(i);
            }
        });

    }
    public void getBoats(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllBoats(loginData.getSerial_id());

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
                                BoatItems boatItems = new BoatItems(verified, petname, type, registration_no, boat_id);
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
                    Toast.makeText(CompanyBoatsList.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
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
