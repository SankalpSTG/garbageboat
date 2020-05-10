package com.latencot.platoon.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.authentication.LoginWithoutPassword;
import com.latencot.platoon.ui.homefragments.HomeFragment;
import com.latencot.platoon.ui.homefragments.MapsNavActivity;
import com.latencot.platoon.ui.homefragments.ProfileFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.math.BigInteger;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView botnav;
    SharedIt shr;
    private BottomNavigationView.OnNavigationItemSelectedListener botnavlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedfragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_menu:
                            selectedfragment = new HomeFragment();
                            break;
                        case R.id.nav_profile:
                            selectedfragment = new ProfileFragment();
                            break;
                        case R.id.nav_map:
                            if(shr.extractpreference(SharedItHelper.credential_id) != null){
                                Intent i = new Intent(HomeActivity.this, MapsNavActivity.class);
                                startActivity(i);
                            }else{
                                Intent i = new Intent(HomeActivity.this, LoginWithoutPassword.class);
                                startActivity(i);
                            }
                            break;
                    }
                    if (selectedfragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.ah_mainframe, selectedfragment).commit();
                        return true;
                    }
                    return false;
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        shr = new SharedIt(this);

        botnav = findViewById(R.id.ah_bottomnavigationpanel);
        botnav.setOnNavigationItemSelectedListener(botnavlistener);
        botnav.setSelectedItemId(R.id.nav_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.ah_mainframe, new HomeFragment()).commit();
    }
}