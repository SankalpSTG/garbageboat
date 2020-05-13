package com.latencot.platoon.ui.profile.manageprojects;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;
import com.latencot.platoon.ui.profile.manageboats.AddBoat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class AddProject extends AppCompatActivity {
    EditText et_projectname, et_projectdescription;
    Button bt_submit;
    CheckBox cb_anonymous;
    SharedIt shr;
//    BigInteger serial_id;
    CompanyLoginData loginData;
    String projectname, projectdescription;
    int isanonymous = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        shr = new SharedIt(this);
//        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        loginData = shr.getCompanyLoginData();
        et_projectname = findViewById(R.id.aap_projectname);
        et_projectdescription = findViewById(R.id.aap_projectdescription);
        bt_submit = findViewById(R.id.aab_submit);
        cb_anonymous = findViewById(R.id.aap_anonymouscheckbox);

        cb_anonymous.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    isanonymous = 1;
                }else{
                    isanonymous = 0;
                }
            }
        });
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectname = et_projectname.getText().toString().trim();
                projectdescription = et_projectdescription.getText().toString().trim();
                addProject();
            }
        });
    }
    public void addProject(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .addProject(loginData.getSerial_id(), projectname, projectdescription, isanonymous);
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
                            String project_id = message.getString("data");
                            Intent i = new Intent(AddProject.this, UpdateProjectLocation.class);
                            i.putExtra(SharedItHelper.project_id, project_id);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AddProject.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
