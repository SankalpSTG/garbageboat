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
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.retrofit.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RegisterCredentials extends AppCompatActivity {
    //EditText
    EditText et_email_id, et_mobile_no;
    //Buttons
    Button bt_submit;
    //String Data
    String email_id, mobile_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credentials);
        et_email_id = findViewById(R.id.arc_emailid);
        et_mobile_no = findViewById(R.id.arc_mobile_no);
        bt_submit = findViewById(R.id.arc_submit);

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
                        JSONObject data = new JSONObject(response.body().string());
                        boolean error = data.getBoolean("error");
                        String error_message = data.getString("error_message");
                        Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                        if(!error){
                            int serial_id = data.getInt("data");
                            SharedIt shr = new SharedIt(getApplicationContext());
                            shr.addpreference(String.valueOf(serial_id), "serial_id");
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
