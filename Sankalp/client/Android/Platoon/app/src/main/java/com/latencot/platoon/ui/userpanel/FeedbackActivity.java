package com.latencot.platoon.ui.userpanel;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;

public class FeedbackActivity extends AppCompatActivity {
    EditText et_header, et_description;
    Spinner sp_category;
    RatingBar rb_rating_bar;
    Button bt_submit;
    String category, header, description;
    float rating = 0;
    BigInteger serial_id;
    SharedIt shr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        shr = new SharedIt(this);
        serial_id = new BigInteger(shr.extractpreference("serial_id"));

        et_header = findViewById(R.id.af_feedbackheader);
        et_description = findViewById(R.id.af_feedbackdescription);
        sp_category = findViewById(R.id.af_feedbackcategories);
        rb_rating_bar = findViewById(R.id.af_feedbackratingbar);
        rb_rating_bar.setNumStars(0);
        bt_submit = findViewById(R.id.af_feedbacksubmit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.feedback_categories, android.R.layout.simple_spinner_item);
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
                if(category.equals("Select Category")){
                    Toast.makeText(FeedbackActivity.this, ErrorMessages.select_a_category, Toast.LENGTH_SHORT).show();
                }else{
                    header = et_header.getText().toString().trim();
                    description = et_description.getText().toString().trim();
                    rating = rb_rating_bar.getRating();
                    if(TextUtils.isEmpty(header) || TextUtils.isEmpty(description)){
                        Toast.makeText(FeedbackActivity.this, ErrorMessages.require_all_fields, Toast.LENGTH_SHORT).show();
                    }else{
                        uploadFeedback();
                    }
                }
            }
        });

    }
    public void uploadFeedback(){

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .uploadFeedback(serial_id, rating, header, description, category);

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
                            Intent i = new Intent(FeedbackActivity.this, HomeActivity.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.exception_occured, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(FeedbackActivity.this, ErrorMessages.no_response_received, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ErrorMessages.default_failure, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
