package com.latencot.platoon.ui.userpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import com.latencot.platoon.R;
import com.latencot.platoon.ui.userpanel.adapters.DeveloperAdapter;
import com.latencot.platoon.ui.userpanel.adapters.DeveloperItems;

public class AboutLatencot extends AppCompatActivity {
    RecyclerView rv_developers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_latencot);

        DeveloperItems developerItems[] = {
                new DeveloperItems("Sankalp Pol", ResourcesCompat.getDrawable(getResources(), R.drawable.sankalp, null)),
                new DeveloperItems("Omkar Prayag", ResourcesCompat.getDrawable(getResources(), R.drawable.omkar, null)),
                new DeveloperItems("Rutuja Vaijapurkar", ResourcesCompat.getDrawable(getResources(), R.drawable.rutuja, null)),
                new DeveloperItems("Pallavi Kamble", ResourcesCompat.getDrawable(getResources(), R.drawable.pallavi, null)),
                new DeveloperItems("Rushikesh Kale", ResourcesCompat.getDrawable(getResources(), R.drawable.rushikesh, null)),
                new DeveloperItems("Shivani Vaidya", ResourcesCompat.getDrawable(getResources(), R.drawable.shivani, null))
        };
        rv_developers = findViewById(R.id.aal_developerrecycler);
        rv_developers.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        DeveloperAdapter developerAdapter = new DeveloperAdapter(this, developerItems);
        rv_developers.setAdapter(developerAdapter);
    }
}
