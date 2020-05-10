package com.latencot.platoon.ui.userpanel.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.ui.basicpanel.FeedbackActivity;
import com.latencot.platoon.ui.homefragments.Adapters.HFRecyclerAdapter2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SolutionAdapter extends RecyclerView.Adapter<SolutionAdapter.ViewHolder>{
    private SolutionItems solutionItems[];
    private LayoutInflater mInflater;
    private SolutionAdapter.ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public SolutionAdapter(Context context, SolutionItems solutionItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.solutionItems = solutionItems;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public SolutionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.solution_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull SolutionAdapter.ViewHolder holder, int position) {
        holder.tv_solutionindex.setText(solutionItems[position].getSerialId().toString());
        holder.tv_solutionheader.setText(solutionItems[position].getHeader());
        holder.tv_solutiondescription.setText(solutionItems[position].getDescription());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return solutionItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_solutionindex, tv_solutionheader, tv_solutiondescription;
        ViewHolder(View itemView) {
            super(itemView);
            tv_solutionindex = itemView.findViewById(R.id.si_solution_id);
            tv_solutionheader = itemView.findViewById(R.id.si_solution_header);
            tv_solutiondescription = itemView.findViewById(R.id.si_solution_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_infotext = view.findViewById(R.id.info_text);
            String info = tv_infotext.getText().toString();
            switch (info){
                case "Suggestions / Feedback":
                    Intent i = new Intent(context, FeedbackActivity.class);
                    context.startActivity(i);
                    break;
            }
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    SolutionItems getItem(int id) {
        return solutionItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(SolutionAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
