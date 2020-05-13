package com.latencot.platoon.ui.authentication;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.retrofit.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;

public class RegisterUser extends AppCompatActivity {
    //showpassword image
    ImageView iv_show_password;
    //Edittexts
    EditText et_password, et_company_name, et_address, et_postal_code;
    //Data
//    BigInteger serial_id;
    CompanyLoginData loginData;
    boolean user_to_be_created = false;
    String company_name, address, password;
    long pin_code;
    //Button
    Button bt_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        SharedIt shr = new SharedIt(getApplicationContext());
//        serial_id = new BigInteger(shr.extractpreference("serial_id"));
        loginData = shr.getCompanyLoginData();
        et_password = findViewById(R.id.aru_password);
        et_address = findViewById(R.id.aru_address);
        et_company_name = findViewById(R.id.aru_company_name);
        et_postal_code = findViewById(R.id.aru_postal_code);
        bt_submit = findViewById(R.id.aru_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                company_name = et_company_name.getText().toString().trim();
                address = et_address.getText().toString().trim();
                pin_code = Long.parseLong(et_postal_code.getText().toString().trim());
                password = et_password.getText().toString().trim();
                if(!TextUtils.isEmpty(company_name) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(Long.toString(pin_code)) && !TextUtils.isEmpty(password)){
                    uploadUserData();
                }
            }
        });
        iv_show_password = findViewById(R.id.aru_show_password);
        iv_show_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv_show_password.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blue_eye).getConstantState()){
                    et_password.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    iv_show_password.setImageDrawable(getResources().getDrawable(R.drawable.black_eye));
                }else{
                    et_password.setInputType(InputType.TYPE_CLASS_TEXT |
                            InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    iv_show_password.setImageDrawable(getResources().getDrawable(R.drawable.blue_eye));
                }
            }
        });
        getUserData();
    }
    public void uploadUserData(){
        Call<ResponseBody> call;
        call = RetrofitClient
                .getInstance()
                .getApi()
                .uploadUserData(loginData.getSerial_id(), company_name, address, pin_code, password);

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

                            Intent i = new Intent(RegisterUser.this, MapPointCenterLocation.class);
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
    public void getUserData(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getUserData(loginData.getSerial_id());

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
                            user_to_be_created = false;
                            JSONObject data = message.getJSONObject("data");
                            String company_name = data.getString("company_name");
                            long postal_code = data.getLong("pincode");
                            String address = data.getString("address");
                            et_company_name.setText(company_name);
                            et_postal_code.setText(Long.toString(postal_code));
                            et_address.setText(address);
                        }else{
                            user_to_be_created = true;
                        }
                        Toast.makeText(RegisterUser.this, "h"+user_to_be_created, Toast.LENGTH_SHORT).show();
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
