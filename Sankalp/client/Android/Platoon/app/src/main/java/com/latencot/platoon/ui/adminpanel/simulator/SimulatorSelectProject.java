package com.latencot.platoon.ui.adminpanel.simulator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.MainActivity;
import com.latencot.platoon.ui.adminpanel.simulator.adapters.ProjectAdapter;
import com.latencot.platoon.ui.profile.manageprojects.AddProject;
import com.latencot.platoon.ui.profile.manageprojects.ProjectList;

import com.latencot.platoon.ui.profile.manageprojects.adapters.ProjectItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class SimulatorSelectProject extends AppCompatActivity {
    private static final String TAG = "SimulatorSelectProject";
    FloatingActionButton bt_add;
    ProjectItems[] projectItems;
//    BigInteger serial_id;
    CompanyLoginData loginData;
    BigInteger projectid;
    SharedIt shr;
    RecyclerView rv_project_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator_select_project);
        shr = new SharedIt(this);
//        serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
        loginData = shr.getCompanyLoginData();
        rv_project_list = findViewById(R.id.assp_projectrecycler);
        rv_project_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        getProjects();
    }
    public void getProjects(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getAllProjects(loginData.getSerial_id());

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
                    Toast.makeText(getApplicationContext(), ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
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
    public void manageViewClickEvent(View view){
        TextView tv_projectid = view.findViewById(R.id.pi_projectid);
        TextView tv_projectname = view.findViewById(R.id.pi_projectname);
        projectid = new BigInteger(tv_projectid.getText().toString().trim());
        String projectname = tv_projectname.getText().toString().trim();
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    startSimulation();
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog
                .Builder(this);
        builder.setMessage("Simulate Project " + projectname)
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener)
                .show();
    }
    public void startSimulation(){
        Intent i = new Intent(SimulatorSelectProject.this, SimulatorSelectBoat.class);
        i.putExtra(SharedItHelper.project_id, projectid.toString());
        startActivity(i);
    }
}
