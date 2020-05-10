package com.latencot.platoon.ui.homefragments.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.authentication.LoginWithoutPassword;
import com.latencot.platoon.ui.basicpanel.FeedbackActivity;
import com.latencot.platoon.ui.userpanel.SubmitProblem;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HFRecyclerAdapter extends RecyclerView.Adapter<HFRecyclerAdapter.ViewHolder> {

    private GridItems gridItems[];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;
    SharedIt shr;
    // data is passed into the constructor
    public HFRecyclerAdapter(Context context, GridItems gridItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.gridItems = gridItems;
        this.context = context;
        shr = new SharedIt(context);
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.gridcard, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView.setText(gridItems[position].getTitle());
        holder.uselessimage.setImageDrawable(gridItems[position].getImagedrawable());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return gridItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView uselessimage;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            uselessimage = itemView.findViewById(R.id.uselessimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_infotext = view.findViewById(R.id.info_text);
            String info = tv_infotext.getText().toString();
            Intent i;
            Intent activity_intent = new Intent(context, LoginWithoutPassword.class);
            switch (info){
                case "Suggestions / Feedback":
                    if(shr.extractpreference(SharedItHelper.credential_id) == null) {
                        context.startActivity(activity_intent);
                    }else {
                        i = new Intent(context, FeedbackActivity.class);
                        context.startActivity(i);
                    }
                    break;
                case "Submit A Problem":
                    if(shr.extractpreference(SharedItHelper.credential_id) == null) {
                        context.startActivity(activity_intent);
                    }else {
                        i = new Intent(context, SubmitProblem.class);
                        context.startActivity(i);
                    }
                    break;
            }
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    GridItems getItem(int id) {
        return gridItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}