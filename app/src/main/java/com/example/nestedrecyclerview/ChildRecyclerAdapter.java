package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.MyViewHolder> {

    ArrayList<String> childArrayList;
    Context context;

    public ChildRecyclerAdapter(ArrayList<String> childArrayList) {
        this.childArrayList = childArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_rowlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mDays.setText(childArrayList.get(position));
        
    }

    @Override
    public int getItemCount() {
        return childArrayList.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {

        TextView mDays;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mDays = itemView.findViewById(R.id.daytext);

        }
    }
}
