package com.latencot.platoon.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonParser;
import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class RegisterCredentials extends AppCompatActivity {
    //EditText
    EditText et_email_id, et_mobile_no;
    //Buttons
    Button bt_submit;
    //String Data
    String email_id, mobile_no;
    //SharedPreference
    SharedIt shr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);
        et_email_id = findViewById(R.id.arc_emailid);
        et_mobile_no = findViewById(R.id.arc_mobile_no);
        bt_submit = findViewById(R.id.arc_submit);
        shr = new SharedIt(this);
        bt_submit.setOnClickListener(register_button_listener);
    }

    View.OnClickListener register_button_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!TextUtils.isEmpty(et_email_id.getText().toString().trim()) && !TextUtils.isEmpty(et_mobile_no.getText().toString().trim())){
                mobile_no = et_mobile_no.getText().toString().trim();
                email_id = et_email_id.getText().toString().trim();
                uploadCredentials();
            }else{
                Toast.makeText(getApplicationContext(), ErrorMessages.multiple_empty_fields_error, Toast.LENGTH_SHORT).show();
            }
        }
    };
    public void uploadCredentials(){

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .uploadCredentials(email_id, mobile_no);
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
                            JSONObject data = message.getJSONObject("data");
                            BigInteger id = new BigInteger(data.getString("serial_id"));
                            int verification_level = data.getInt("verification_level");
                            int account_level = data.getInt("account_level");
                            CompanyLoginData logindata = new CompanyLoginData(id, verification_level, account_level);
                            shr.saveCompanyLoginData(logindata);
//                            shr.addpreference(data.getString("serial_id"), SharedItHelper.credential_id);
//                            shr.addpreference(data.getString("verification_level"), SharedItHelper.verification_level);
//                            shr.addpreference(data.getString("account_level"), SharedItHelper.account_level);
                            Intent i = new Intent(RegisterCredentials.this, RegisterUser.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
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
