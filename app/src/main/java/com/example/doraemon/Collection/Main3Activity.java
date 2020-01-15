package com.example.doraemon.Collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doraemon.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3Activity extends Fragment {
        public static ExampleAdapter adapter;
        public List<ExampleItem> exampleList;
        View v;
        public static final String Extra = "com.example.doraemon.Extra";
        public static ArrayList<String> mTitle = new ArrayList<String>(Arrays.asList("Receiving Promise In Advance", "Reverse Flow Boat", "Train Rope", "Mood Orchestra", "Super Gloves", "Gravitation Paint", "Personal Satellite", "Sword Round Lightning", "Camping Hat", "Extract Plant Production", "Robe to call wild animal", "Call and order phone", "Paper House", "Drill Machine", "Buggy", "Floating Water Picnic", "Special Purse", "Auto Lightning Unit", "A Luring Food Fish", "Captain Hat", "Controling Atmospheric Pressure Light", "Undersea Tent", "Special Wood", "Dream Confirmation Hand", "Mini Baseball Player", "Mini Stadium", "Tulip Time Machine", "Concentrated Food", "3D Copy Paper", "Mini Universal Food Factory", "Time TV", "Safe Traffic Observer", "Elastic Tube", "Deep Sea Cream", "Air pistol", "All Purpose Nest Box", "Gyro Capsule", "Edible Space Suit", "Life Saving Raft", "Cape of Evasion", "Camping Capsule", "Clay Race Cart", "Emergency Elevator", "Momotaro Dango", "Clothes Changing Camera", "Translation konyaku", "Air cannon", "Pass Loop", "Small light", "Time Furoshiki", "Anywhere door", "Take-copter", "Time machine", "4D pocket"));

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
            v = inflater.inflate(R.layout.activity_main3,parent,false);
            fillExampleList();
            setUpRecyclerView();
            return v;
        }

        private void fillExampleList() {
            exampleList = new ArrayList<>();
            for (int i = 0; i < 54; i++) {
                exampleList.add(new ExampleItem(R.drawable.w, mTitle.get(i), "description"));
            }
        }

        private void setUpRecyclerView() {
            RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            adapter = new ExampleAdapter(exampleList);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    openMainActivity(position);
                }
            });

        }

        public void openMainActivity(int position){
            Intent intent = new Intent(this.getContext(),Main4Activity.class);
            intent.putExtra(Extra,position);
            startActivity(intent);
        }
}

