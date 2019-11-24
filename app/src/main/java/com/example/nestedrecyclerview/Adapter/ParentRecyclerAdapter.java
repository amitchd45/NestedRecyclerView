package com.example.nestedrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.R;

import java.util.ArrayList;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.MyViewHolder> {

    ArrayList<String> parentArrayList;
    Context context;

    public ParentRecyclerAdapter(ArrayList<String> parentArrayList, Context context) {
        this.parentArrayList = parentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_rowlayout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mItemName.setText(parentArrayList.get(position));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.mChildRV.setLayoutManager(layoutManager);
        holder.mChildRV.setHasFixedSize(true);
        ArrayList<String> dayArrayList = new ArrayList<>();

        if (parentArrayList.get(position).equals("Item one")) {

            String[] days = {"sat", "sun", "mon"};

            for (int i = 0; i < days.length; i++) {
                dayArrayList.add(days[i]);
            }
        } else if (parentArrayList.get(position).equals("Item two")){

            String[] days = {"sat", "sun", "mon", "tue", "wed","sat", "sun", "mon", "tue", "wed"};

            for (int i = 0; i < days.length; i++) {
                dayArrayList.add(days[i]);
            }
        }

        else {

            String[] days = {"sat", "sun", "mon", "tue", "wed","sat", "sun", "mon", "tue", "wed","sat", "sun", "mon", "tue", "wed"};

            for (int i = 0; i < days.length; i++) {
                dayArrayList.add(days[i]);
            }
        }


        ChildRecyclerAdapter childRecyclerAdapter = new ChildRecyclerAdapter(dayArrayList);
        holder.mChildRV.setAdapter(childRecyclerAdapter);
        childRecyclerAdapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mItemName;
        RecyclerView mChildRV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.itemname);
            mChildRV = itemView.findViewById(R.id.childRV);
        }
    }
}
