package com.latencot.platoon.ui.profile.manageboats;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;
import com.latencot.platoon.ui.userpanel.SubmitProblem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class AddBoat extends AppCompatActivity {
    EditText et_petname, et_registrationno;
    Spinner sp_boattype;
    ImageView iv_boatsampleimage;
    Button bt_submit;
    String petname, boattype = "master";
//    BigInteger serial_id;
    CompanyLoginData loginData;
    BigInteger registration_no;
    SharedIt shr;
    int RESULT_INT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat);

        shr = new SharedIt(this);
        loginData = shr.getCompanyLoginData();

        et_petname = findViewById(R.id.aab_petname);
        et_registrationno = findViewById(R.id.aab_registrationno);
        sp_boattype = findViewById(R.id.aab_boattype);
        bt_submit = findViewById(R.id.aab_submit);
        iv_boatsampleimage = findViewById(R.id.aab_boatsampleimage);

        iv_boatsampleimage.setImageResource(R.drawable.master_boat_image);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.boat_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_boattype.setAdapter(adapter);

        sp_boattype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                boattype = (String) adapterView.getItemAtPosition(i);
                if(boattype.equals("master")){
                    iv_boatsampleimage.setImageResource(R.drawable.master_boat_image);
                }else{
                    iv_boatsampleimage.setImageResource(R.drawable.slave_boat_image);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                boattype = "";
            }
        });
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                petname = et_petname.getText().toString().trim();
                registration_no = new BigInteger(et_registrationno.getText().toString().trim());
                addBoat();
            }
        });
    }
    public void addBoat(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .addBoat(loginData.getSerial_id(), registration_no, boattype, petname);
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
                            Intent i = new Intent(AddBoat.this, HomeActivity.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AddBoat.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
