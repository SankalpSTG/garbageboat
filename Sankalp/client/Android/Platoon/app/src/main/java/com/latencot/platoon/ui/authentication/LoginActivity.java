package com.latencot.platoon.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class LoginActivity extends AppCompatActivity {
    EditText et_email_id, et_password;
    Button bt_sign_in;
    String email_id, password;
    SharedIt shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email_id = findViewById(R.id.al_emailid);
        et_password = findViewById(R.id.al_password);
        bt_sign_in = findViewById(R.id.al_submit);
        bt_sign_in.setOnClickListener(sign_in_listener);
        shr = new SharedIt(getApplicationContext());
    }

    View.OnClickListener sign_in_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!TextUtils.isEmpty(et_email_id.getText().toString().trim()) && !TextUtils.isEmpty(et_password.getText().toString().trim())){
                password = et_password.getText().toString().trim();
                email_id = et_email_id.getText().toString().trim();
                attemptLogIn();
            }else{
                Toast.makeText(getApplicationContext(), ErrorMessages.multiple_empty_fields_error, Toast.LENGTH_SHORT).show();
            }
        }
    };
    public void attemptLogIn(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .logIn(email_id, password);
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
                            Toast.makeText(LoginActivity.this, ErrorMessages.login_successful, Toast.LENGTH_SHORT).show();
                            shr.addpreference(data.getString("serial_id"), SharedItHelper.credential_id);
                            shr.addpreference(data.getString("verification_level"), SharedItHelper.verification_level);
                            shr.addpreference(data.getString("account_level"), SharedItHelper.account_level);
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                            finish();
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
