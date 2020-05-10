package com.latencot.platoon.ui.homefragments;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.MainActivity;
import com.latencot.platoon.ui.authentication.LoginActivity;
import com.latencot.platoon.ui.authentication.RegisterCredentials;
import com.latencot.platoon.ui.authentication.RegisterUser;
import com.latencot.platoon.ui.profile.manageboats.CompanyBoatsList;
import com.latencot.platoon.ui.profile.manageprojects.ProjectList;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.math.BigInteger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    /*Button btetnamesubmit, btetemailsubmit, btetpasswordsubmit;
    ImageView btetname, btetnamecancel, btetemail, btetemailcancel, btetpassword, btetpasswordcancel;
    EditText etname, etemail, etpassword, etpasswordconfirm;
    Button loginbutton, registerbutton;*/
    TextView pf_tvmanageboats, pf_tvmanageprojects;
    TextView tvname, tvemail, tvpassword, tvaddress, tvnoofprojects, tvheadername, tvheaderemail;
    //SharedPreference Class Variable
    SharedIt shr;
    RelativeLayout rl_headeractions, rl_headerdata;
    //SharedPreference Data
    BigInteger serial_id;
    int verification_level;
    //Login and Register Buttons
    Button bt_login, bt_register, bt_logout;
    //ImageView
    ImageView iv_logo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_fragment, container, false);
        shr = new SharedIt(getActivity());

        if(shr.extractpreference(SharedItHelper.credential_id) != null){
            serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
            verification_level = Integer.parseInt(shr.extractpreference(SharedItHelper.verification_level));
            if(verification_level != 0) {
                fetchUserDetails();
            }else{
                LinearLayout company_data_layout = view.findViewById(R.id.pf_userdata);
                company_data_layout.setVisibility(View.GONE);
            }
        }else{
            LinearLayout company_data_layout = view.findViewById(R.id.pf_userdata);
            company_data_layout.setVisibility(View.GONE);
        }

        pf_tvmanageboats = view.findViewById(R.id.pf_tvmanageboats);
        pf_tvmanageprojects = view.findViewById(R.id.pf_tvmanageprojects);
        pf_tvmanageboats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CompanyBoatsList.class);
                startActivity(i);
            }
        });
        pf_tvmanageprojects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ProjectList.class);
                startActivity(i);
            }
        });


        tvname = view.findViewById(R.id.pf_tvname);
        tvemail = view.findViewById(R.id.pf_tvemail);
        tvpassword = view.findViewById(R.id.pf_tvpassword);
        tvaddress = view.findViewById(R.id.pf_tvbaselocation);
        tvnoofprojects = view.findViewById(R.id.pf_tvnoofprojects);
        tvheaderemail = view.findViewById(R.id.pf_tvheaderemail);
        tvheadername = view.findViewById(R.id.pf_tvheadername);
        rl_headeractions = view.findViewById(R.id.pf_actions);
        rl_headerdata = view.findViewById(R.id.pf_data);
        bt_login = view.findViewById(R.id.pf_login_button);
        bt_register = view.findViewById(R.id.pf_register_button);
        bt_logout = view.findViewById(R.id.pf_btlogout);
        iv_logo = view.findViewById(R.id.pf_ivlogo);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), RegisterCredentials.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shr.extractpreference(SharedItHelper.credential_id) != null){
                    shr.removepreference(SharedItHelper.credential_id);
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ah_mainframe, new HomeFragment()).commit();
            }
        });
        return view;
    }
    public void fetchUserDetails(){
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .getUserAllData(serial_id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    Toast.makeText(getActivity(), "Response Body is not null", Toast.LENGTH_SHORT).show();
                    try {
                        JSONObject message = new JSONObject(response.body().string());
                        boolean error = message.getBoolean("error");
                        String error_message = message.getString("error_message");
                        if(!error){
                            JSONObject data = message.getJSONObject("data");
                            String name = data.getString("company_name");
                            String email = data.getString("email_id");
                            String address = data.getString("address");
                            long pincode = data.getLong("pincode");
                            long noofprojects = data.getInt("no_of_projects");
                            String logo_url = data.getString("logo_url");
                            tvname.setText("Name: " + name);
                            tvemail.setText("Email: " + email);
                            tvaddress.setText("Address: " + address + ", " + pincode);
                            tvnoofprojects.setText("No Of Projects: " + noofprojects);
                            tvheadername.setText(name);
                            tvheaderemail.setText(email);
                            Picasso.get().load(logo_url).into(iv_logo);
                            rl_headeractions.setVisibility(View.GONE);
                            rl_headerdata.setVisibility(View.VISIBLE);
                            Toast.makeText(getActivity(), "Error was not false", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), error_message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getActivity(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClick(View view){

    }
}