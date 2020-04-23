package com.example.permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btRequest,btCheck;
    static final int REQUEST_CODE=123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRequest= findViewById(R.id.bt_request);
        btCheck=findViewById(R.id.bt_check);

        btRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CAMERA)+
                            ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_CONTACTS)+
                            ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED){
                        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CAMERA)||
                                ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_CONTACTS) ||
                                ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                            AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Grant those permission");
                            builder.setMessage("Camera , Read Contacts and Storage");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(
                                            MainActivity.this,
                                            new String[]{
                                                    Manifest.permission.CAMERA,
                                                    Manifest.permission.READ_CONTACTS,
                                                    Manifest.permission.READ_EXTERNAL_STORAGE
                                            },
                                            REQUEST_CODE
                                    );
                                }
                            });
                            builder.setNegativeButton("Cancel",null);
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }else{
                            ActivityCompat.requestPermissions(
                                    MainActivity.this,
                                    new String[]{
                                            Manifest.permission.CAMERA,
                                            Manifest.permission.READ_CONTACTS,
                                            Manifest.permission.READ_EXTERNAL_STORAGE
                                    },
                                    REQUEST_CODE
                            );
                        }

                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Permission Already Granted",
                                Toast.LENGTH_SHORT).show();
                    }
                }

        });

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri= Uri.fromParts("package",
                        getPackageName(),null);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CODE){
                    if((grantResults.length>0) && (grantResults[0] +grantResults[1] +grantResults[2] ==PackageManager.PERMISSION_GRANTED)){
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();

            }else{
                        Toast.makeText(getApplicationContext(),"Permisssion denied",Toast.LENGTH_SHORT).show();
            }
    }
    }
}



