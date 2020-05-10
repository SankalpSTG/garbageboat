package com.latencot.platoon.ui.homefragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.homefragments.Adapters.GridItems;
import com.latencot.platoon.ui.homefragments.Adapters.HFRecyclerAdapter;
import com.latencot.platoon.ui.homefragments.Adapters.HFRecyclerAdapter2;

import java.math.BigInteger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView, controlsrecyclerview;
    private ListAdapter mListadapter;
    private TextView mTextViewEmpty;
    private ImageView mImageViewEmpty;
    private SharedIt shr;
    BigInteger serial_id;
    int verification_level;
    int account_level;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = view.findViewById(R.id.hf_recyclerview);
        controlsrecyclerview = view.findViewById(R.id.hf_controlsrecyclerview);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        controlsrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        shr = new SharedIt(getActivity());
        if(shr.extractpreference(SharedItHelper.credential_id) != null){
            serial_id = new BigInteger(shr.extractpreference(SharedItHelper.credential_id));
            verification_level = Integer.parseInt(shr.extractpreference(SharedItHelper.verification_level));
            account_level = Integer.parseInt(shr.extractpreference(SharedItHelper.account_level));
            if(verification_level == 0){
                controlsrecyclerview.setVisibility(View.GONE);
            }
        }else{
            controlsrecyclerview.setVisibility(View.GONE);
        }
        GridItems gridItems[] = {
            new GridItems("Boats", ResourcesCompat.getDrawable(getResources(), R.drawable.boat192x192, null)),
            new GridItems("Working", ResourcesCompat.getDrawable(getResources(), R.drawable.working192x192_2, null)),
            new GridItems("Success Stories", ResourcesCompat.getDrawable(getResources(), R.drawable.success192x192_2, null)),
            new GridItems("Live Map View", ResourcesCompat.getDrawable(getResources(), R.drawable.map192x192_2, null)),
            new GridItems("Project Statistics", ResourcesCompat.getDrawable(getResources(), R.drawable.statistics192x192_2, null)),
            new GridItems("Suggestions / Feedback", ResourcesCompat.getDrawable(getResources(), R.drawable.feedback192x192_2, null)),
            new GridItems("Submit A Problem", ResourcesCompat.getDrawable(getResources(), R.drawable.problem192x192_2, null)),
            new GridItems("Crowd Funding", ResourcesCompat.getDrawable(getResources(), R.drawable.crowdfunding192x192_2, null)),
            new GridItems("Latencot", ResourcesCompat.getDrawable(getResources(), R.drawable.latencot192x192, null)),
            new GridItems("Upcoming Products", ResourcesCompat.getDrawable(getResources(), R.drawable.upcoming192x192_3, null)),
            new GridItems("Supporting Organizations", ResourcesCompat.getDrawable(getResources(), R.drawable.organization192x192_3, null)),
            new GridItems("About Us", ResourcesCompat.getDrawable(getResources(), R.drawable.about192x192_2, null))
        };
        GridItems controlItems[] = {
            new GridItems("Controller", ResourcesCompat.getDrawable(getResources(), R.drawable.controller192x192_2, null)),
            new GridItems("Simulator", ResourcesCompat.getDrawable(getResources(), R.drawable.simulator192x192_2, null)),
            new GridItems("Write A Story", ResourcesCompat.getDrawable(getResources(), R.drawable.writestory192x192_2, null)),
            new GridItems("Maintenance Schedule", ResourcesCompat.getDrawable(getResources(), R.drawable.maintenance192x192_2, null)),
            new GridItems("Edit Boats", ResourcesCompat.getDrawable(getResources(), R.drawable.edit192x192_2, null)),
            new GridItems("Garbage Analytics", ResourcesCompat.getDrawable(getResources(), R.drawable.analytics192x192_2, null))
        };
        HFRecyclerAdapter recyclerAdapter = new HFRecyclerAdapter(getActivity(), gridItems);
        HFRecyclerAdapter2 controlsAdapter = new HFRecyclerAdapter2(getActivity(), controlItems);
        recyclerView.setAdapter(recyclerAdapter);
        controlsrecyclerview.setAdapter(controlsAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        controlsrecyclerview.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
