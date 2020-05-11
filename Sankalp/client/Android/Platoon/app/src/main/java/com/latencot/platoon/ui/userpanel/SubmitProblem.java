package com.latencot.platoon.ui.userpanel;

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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;
import com.latencot.platoon.ui.userpanel.adapters.ProblemAdapter;
import com.latencot.platoon.ui.userpanel.adapters.ProblemItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class SubmitProblem extends AppCompatActivity {
    private static final String TAG = "SubmitProblem";
    EditText et_problemheader;
    EditText et_problemdescription;
    Spinner sp_category;
    Button bt_submit;
    String header, description, category;
    BigInteger serial_id;
    SharedIt shr;
    ProblemItems problemItems[];
    RecyclerView rv_problems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_problem);

        shr = new SharedIt(this);
        serial_id = new BigInteger(shr.extractpreference("serial_id"));

        et_problemheader = findViewById(R.id.asp_problemheader);
        et_problemdescription = findViewById(R.id.asp_problemdescription);
        bt_submit = findViewById(R.id.asp_problemsubmit);
        sp_category = findViewById(R.id.asp_problemcategories);
        rv_problems = findViewById(R.id.asp_previousproblems);


        rv_problems.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.problem_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_category.setAdapter(adapter);

        sp_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                category = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                category = "";
            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                header = et_problemheader.getText().toString().trim();
                description = et_problemdescription.getText().toString().trim();
                if(TextUtils.isEmpty(header) || TextUtils.isEmpty(description) || TextUtils.isEmpty(category)){
                    Toast.makeText(SubmitProblem.this, ErrorMessages.require_all_fields, Toast.LENGTH_SHORT).show();
                }else{
                    uploadProblem();
                }
            }
        });
        getProblemHeaders();
    }
    public void uploadProblem(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .uploadProblem(serial_id, header, description, category);

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
                            Intent i = new Intent(SubmitProblem.this, HomeActivity.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SubmitProblem.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getProblemHeaders(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getSpecificProblems(serial_id);
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
                            ArrayList<ProblemItems> problemsarraylist = new ArrayList<ProblemItems>();
                            JSONArray problemjsonarray = data.getJSONArray("data");
                            for(int i = 0; i < problemjsonarray.length(); i++){
                                JSONObject problemjsonobject = problemjsonarray.getJSONObject(i);
                                BigInteger problem_id = BigInteger.valueOf(problemjsonobject.getLong("serial_id"));
                                String problem_header = problemjsonobject.getString("header");
                                Log.d(TAG, "onResponse: " + problem_id + " : " + problem_header);
                                ProblemItems problemItem = new ProblemItems(problem_id, problem_header);
                                problemsarraylist.add(problemItem);
                            }
                            ProblemItems[] items = problemsarraylist.toArray(new ProblemItems[problemsarraylist.size()]);
                            problemItems = items;
                            showProblemsList();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SubmitProblem.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    void showProblemsList(){
        ProblemAdapter problemAdapter = new ProblemAdapter(this, problemItems);
        rv_problems.setAdapter(problemAdapter);
        rv_problems.setItemAnimator(new DefaultItemAnimator());
    }
}
