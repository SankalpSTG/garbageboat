package com.latencot.platoon.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class LoginWithoutPassword extends AppCompatActivity {
    TextInputLayout til_mobileno;
    EditText et_emailid, et_mobileno;
    String emailid, mobileno;
    Button bt_submit;
    SharedIt shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_without_password);

        shr = new SharedIt(this);

        til_mobileno = findViewById(R.id.alwp_mobile_text_input_layout);
        et_emailid = findViewById(R.id.alwp_emailid);
        et_mobileno = findViewById(R.id.alwp_mobileno);
        bt_submit = findViewById(R.id.alwp_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(til_mobileno.getVisibility() == View.GONE){
                    emailid = et_emailid.getText().toString();
                    loginWithEmail();
                }else{
                    emailid = et_emailid.getText().toString();
                    mobileno = et_mobileno.getText().toString();
                    loginWithEmailAndMobileNo();
                }
            }
        });
    }
    public void loginWithEmail(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .loginWithoutPassword(emailid);
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
                            Toast.makeText(LoginWithoutPassword.this, ErrorMessages.login_successful, Toast.LENGTH_SHORT).show();
                            BigInteger id = new BigInteger(data.getString("serial_id"));
                            int verification_level = data.getInt("verification_level");
                            int account_level = data.getInt("account_level");
                            CompanyLoginData logindata = new CompanyLoginData(id, verification_level, account_level);
                            shr.saveTemporaryLoginData(logindata);
//                            shr.addpreference(data.getString("serial_id"), SharedItHelper.credential_id);
//                            shr.addpreference(data.getString("verification_level"), SharedItHelper.verification_level);
//                            shr.addpreference(data.getString("account_level"), SharedItHelper.account_level);
                            Intent i = new Intent(LoginWithoutPassword.this, HomeActivity.class);
                            startActivity(i);
                            finishAffinity();
                        }else{
                            til_mobileno.setVisibility(View.VISIBLE);
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
    public void loginWithEmailAndMobileNo(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .loginWithEmailAndMobileNo(emailid, mobileno);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        Toast.makeText(LoginWithoutPassword.this, error_message, Toast.LENGTH_SHORT).show();
                        if(!error){
                            JSONObject data = message.getJSONObject("data");
                            Toast.makeText(LoginWithoutPassword.this, ErrorMessages.login_successful, Toast.LENGTH_SHORT).show();
                            shr.addpreference(data.getString("serial_id"), SharedItHelper.credential_id);
                            shr.addpreference(data.getString("verification_level"), SharedItHelper.verification_level);
                            shr.addpreference(data.getString("account_level"), SharedItHelper.account_level);
                            Intent i = new Intent(LoginWithoutPassword.this, HomeActivity.class);
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
