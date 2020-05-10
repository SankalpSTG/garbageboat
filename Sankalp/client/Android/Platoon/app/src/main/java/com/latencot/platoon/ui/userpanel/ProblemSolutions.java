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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.userpanel.adapters.ProblemAdapter;
import com.latencot.platoon.ui.userpanel.adapters.ProblemItems;
import com.latencot.platoon.ui.userpanel.adapters.SolutionAdapter;
import com.latencot.platoon.ui.userpanel.adapters.SolutionItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ProblemSolutions extends AppCompatActivity {
    BigInteger problem_id = new BigInteger("0");
    TextView tv_nosolution;
    RecyclerView rv_solutions;
    SolutionItems solutionItems[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_solutions);

        tv_nosolution = findViewById(R.id.aps_nosolution);
        rv_solutions = findViewById(R.id.aps_solutionsrecycler);

        rv_solutions.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if(extras.getString(SharedItHelper.problem_id, "0") != null) {
            problem_id = new BigInteger(extras.getString(SharedItHelper.problem_id, "0"));
        }
        getProblemSolutions();
    }
    void getProblemSolutions(){
        Toast.makeText(this, problem_id.toString(), Toast.LENGTH_SHORT).show();
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getSpecificProblemSolutions(problem_id);

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
                            tv_nosolution.setVisibility(View.GONE);
                            ArrayList<SolutionItems> solutionItemsArrayList = new ArrayList<SolutionItems>();
                            JSONArray solutionsjsonarray = data.getJSONArray("data");
                            for(int i = 0; i < solutionsjsonarray.length(); i++){
                                JSONObject solutionjsonobject = solutionsjsonarray.getJSONObject(i);
                                BigInteger solution_id = BigInteger.valueOf(solutionjsonobject.getLong("serial_id"));
                                String solution_header = solutionjsonobject.getString("header");
                                String solution_description = solutionjsonobject.getString("description");
                                SolutionItems solutionItem = new SolutionItems(solution_id, solution_header, solution_description);
                                solutionItemsArrayList.add(solutionItem);
                            }
                            SolutionItems[] items = solutionItemsArrayList.toArray(new SolutionItems[solutionItemsArrayList.size()]);
                            solutionItems = items;

                            showSolutionsList();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ProblemSolutions.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    void showSolutionsList(){
        SolutionAdapter solutionAdapter = new SolutionAdapter(getApplicationContext(), solutionItems);
        rv_solutions.setAdapter(solutionAdapter);
        rv_solutions.setItemAnimator(new DefaultItemAnimator());
    }
}
