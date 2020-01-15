package com.example.doraemon.Collection;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doraemon.R;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    private VideoAdapter adapter;
    private ArrayList<videoitem>[] exampleList = new ArrayList[54];
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fillExampleList();
        Intent intent = getIntent();
        int position = intent.getIntExtra(Main3Activity.Extra, 0);
        setUpRecyclerView(position);
    }

    private void fillExampleList(){
        for(int i = 0; i<54; i++){
            exampleList[i] = new ArrayList<videoitem>();
            exampleList[i].add(new videoitem("VwubeB2i5qM"));
        }
    }

    private void setUpRecyclerView(int position) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view1);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new VideoAdapter(exampleList[position],getSupportFragmentManager());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}

