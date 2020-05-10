package com.latencot.platoon.ui.userpanel.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.basicpanel.FeedbackActivity;
import com.latencot.platoon.ui.homefragments.Adapters.GridItems;
import com.latencot.platoon.ui.homefragments.Adapters.HFRecyclerAdapter2;
import com.latencot.platoon.ui.userpanel.ProblemSolutions;

import java.math.BigInteger;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ViewHolder>{
    private ProblemItems problemItems[];
    private LayoutInflater mInflater;
    private ProblemAdapter.ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public ProblemAdapter(Context context, ProblemItems problemItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.problemItems = problemItems;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ProblemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.problem_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ProblemAdapter.ViewHolder holder, int position) {
        holder.tv_problemindex.setText(problemItems[position].getProblem_id().toString());
        holder.tv_problemheader.setText(problemItems[position].getProblem_header());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return problemItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_problemindex, tv_problemheader;
        ViewHolder(View itemView) {
            super(itemView);
            tv_problemindex = itemView.findViewById(R.id.pi_problemindex);
            tv_problemheader = itemView.findViewById(R.id.pi_problemheader);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_index = view.findViewById(R.id.pi_problemindex);
            String problem_id = tv_index.getText().toString();
            Intent i = new Intent(context, ProblemSolutions.class);
            i.putExtra(SharedItHelper.problem_id, problem_id);
            context.startActivity(i);
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ProblemItems getItem(int id) {
        return problemItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(ProblemAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
