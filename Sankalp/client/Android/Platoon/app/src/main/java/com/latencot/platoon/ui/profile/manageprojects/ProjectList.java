package com.latencot.platoon.ui.profile.manageprojects;

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
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.profile.manageboats.AddBoat;
import com.latencot.platoon.ui.profile.manageboats.CompanyBoatsList;
import com.latencot.platoon.ui.profile.manageboats.adapters.BoatAdapter;
import com.latencot.platoon.ui.profile.manageboats.adapters.BoatItems;
import com.latencot.platoon.ui.profile.manageprojects.adapters.ProjectAdapter;
import com.latencot.platoon.ui.profile.manageprojects.adapters.ProjectItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ProjectList extends AppCompatActivity {
    private static final String TAG = "ProjectList";
    FloatingActionButton bt_add;
    ProjectItems projectItems[];
    BigInteger serial_id;
    SharedIt shr;
    RecyclerView rv_project_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        shr = new SharedIt(this);
        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        rv_project_list = findViewById(R.id.apl_projectrecycler);
        rv_project_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        getProjects();
        bt_add = findViewById(R.id.apl_addbutton);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProjectList.this, AddProject.class);
                startActivity(i);
            }
        });
    }
    public void getProjects(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllProjects(serial_id);

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
                            ArrayList<ProjectItems> projectarraylist = new ArrayList<ProjectItems>();
                            JSONArray projectjsonarray = data.getJSONArray("data");
                            for(int i = 0; i < projectjsonarray.length(); i++){
                                JSONObject boatsjsonobject = projectjsonarray.getJSONObject(i);
                                BigInteger project_id = BigInteger.valueOf(boatsjsonobject.getLong("serial_id"));
                                String project_name = boatsjsonobject.getString("project_name");
                                String project_description = boatsjsonobject.getString("project_description");
                                int is_anonymous = boatsjsonobject.getInt("is_anonymous");
                                Log.d(TAG, "onResponse: " + project_id + " : " + project_name);
                                ProjectItems projectItems = new ProjectItems(project_id, project_name, project_description, is_anonymous);
                                projectarraylist.add(projectItems);
                            }
                            ProjectItems[] items = projectarraylist.toArray(new ProjectItems[projectarraylist.size()]);
                            projectItems = items;
                            showProjectList();
                        }else{
                            Toast.makeText(getApplicationContext(), error_message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ProjectList.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showProjectList(){

        ProjectAdapter projectAdapter = new ProjectAdapter(this, projectItems);
        rv_project_list.setAdapter(projectAdapter);
        rv_project_list.setItemAnimator(new DefaultItemAnimator());
    }
}
