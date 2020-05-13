package com.latencot.platoon.ui.authentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import org.apache.commons.io.FileUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.CompanyLoginData;
import com.latencot.platoon.model.ErrorMessages;
import com.latencot.platoon.model.ImageClass;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.retrofit.RetrofitClient;
import com.latencot.platoon.ui.HomeActivity;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.Objects;

public class UploadFile extends AppCompatActivity {
    public Button bt_upload_logo_image;
    public ImageView iv_logo_imageview;
    public RelativeLayout rl_iv_front_end;
    public int IMG_REQUEST = 1234;
    public int RESULT_LOAD_IMAGE = 1234;
    private Bitmap bitmap;
    private String stringImage;
//    private BigInteger serial_id;
    CompanyLoginData loginData;
    private SharedIt shr;
    private Uri file_uri;
    private String picturePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);
        bt_upload_logo_image = findViewById(R.id.auf_submit);
        iv_logo_imageview = findViewById(R.id.auf_image_logo);
        rl_iv_front_end = findViewById(R.id.auf_image_front_end);
        bt_upload_logo_image.setEnabled(false);
        shr = new SharedIt(this);
//        serial_id = new BigInteger(shr.extractpreference("serial_id"));
//        Toast.makeText(getApplicationContext(), serial_id.toString(), Toast.LENGTH_SHORT).show();
        loginData = shr.getCompanyLoginData();
        rl_iv_front_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Bundle result = new Bundle();
                result.putInt("RESULT", RESULT_LOAD_IMAGE);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, IMG_REQUEST);
            }
        });
        bt_upload_logo_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    uploadImage();
                } catch (URISyntaxException e) {
                    Toast.makeText(getApplicationContext(), "URI Exception", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            File imgFile = new  File(picturePath);

            if(imgFile.exists()){

                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                iv_logo_imageview.setImageBitmap(myBitmap);
                rl_iv_front_end.setVisibility(View.GONE);
                bt_upload_logo_image.setEnabled(true);
            }
        }
    }

    private void getStringImage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        stringImage = Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    public void uploadImage() throws URISyntaxException {
        RequestBody extra_data = RequestBody.create(MediaType.parse("multipart/form-data"), loginData.getSerial_id().toString());
        File image_file = new File(picturePath);
        RequestBody file_data = RequestBody.create(MediaType.parse("multipart/form-data"), image_file);
        MultipartBody.Part file_image = MultipartBody.Part.createFormData("logo", image_file.getName(), file_data);
        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getApi()
                .uploadImage(extra_data, file_image);

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
                            Toast.makeText(getApplicationContext(), ErrorMessages.success_message, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(UploadFile.this, HomeActivity.class);
                            startActivity(i);
                            finish();
                        }else{
                            Toast.makeText(UploadFile.this, ErrorMessages.failed_to_upload_image, Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException | JSONException e) {
                        Toast.makeText(getApplicationContext(), ErrorMessages.error_occured, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}