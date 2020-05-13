package com.latencot.platoon.ui.profile.manageboats;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;
import com.latencot.platoon.ui.authentication.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class BoatDetails extends AppCompatActivity {
    SharedIt shr;
    TextView tv_registrationno, tv_petname, tv_type, tv_verified;
    ImageView iv_boatimage;
    BigInteger registration_no;
    String petname, type;
    int verified;
    Button bt_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_details);

        tv_petname = findViewById(R.id.abd_petname);
        tv_registrationno = findViewById(R.id.abd_registrationno);
        tv_type = findViewById(R.id.abd_type);
        tv_verified = findViewById(R.id.abd_verified);
        iv_boatimage = findViewById(R.id.abd_boatimage);
        bt_delete = findViewById(R.id.abd_deletebutton);
        shr = new SharedIt(this);

        Intent i = getIntent();
        Bundle intentdata = i.getExtras();

        registration_no = new BigInteger(intentdata.getString(SharedItHelper.registration_no));

        getBoatData();
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBoatData();
            }
        });
    }
    public void getBoatData(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getBoatSpecific(registration_no);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        if(!error){
                            JSONObject data = message.getJSONObject("data");
                            petname = data.getString("pet_name");
                            type = data.getString("type");
                            verified = data.getInt("verified");
                            tv_petname.setText(petname);
                            tv_registrationno.setText(registration_no.toString());
                            tv_type.setText(type);
                            if(verified == 0){
                                tv_verified.setText("To Be Verified");
                            }else{
                                tv_verified.setText("Verified");
                            }
                            if(type.equals("master")){
                                iv_boatimage.setImageResource(R.drawable.master_boat_image);
                            }else{
                                iv_boatimage.setImageResource(R.drawable.slave_boat_image);
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(BoatDetails.this, CompanyBoatsList.class);
                            startActivity(i);
                            finishAffinity();
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
    public void deleteBoatData(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .deleteBoatSpecific(registration_no);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        if(!error){
                            Intent i = new Intent(BoatDetails.this, CompanyBoatsList.class);
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
}
