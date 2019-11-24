package com.example.nestedrecyclerview.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedrecyclerview.Adapter.ParentRecyclerAdapter;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<String> itemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.ParentRV);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        adapter = new ParentRecyclerAdapter(itemArrayList,MainActivity.this);
        mRecyclerView.setAdapter(adapter);

        String [] items ={"Item one","Item two","Item three","Item four","Item five"};

        for(int i=0;i<items.length;i++){
            itemArrayList.add(items[i]);
        }
        adapter.notifyDataSetChanged();
    }
}
