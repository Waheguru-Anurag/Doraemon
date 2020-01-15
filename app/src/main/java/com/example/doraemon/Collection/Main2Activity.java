package com.example.doraemon.Collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doraemon.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragmentX;

public class Main2Activity extends Fragment {
        private static final String Tag = Main2Activity.class.getSimpleName();
        private YouTubePlayerFragmentX youTubePlayerFragmentX;
        private YouTubePlayer Player;
        Button button;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_main2,parent,false);
        button = (Button)v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer();
            }
        });


        return v;
    }

    private void initializeYouTubePlayer(){
        youTubePlayerFragmentX = (YouTubePlayerFragmentX)getChildFragmentManager().findFragmentById(R.id.View);
        if(youTubePlayerFragmentX == null)
            return;
        youTubePlayerFragmentX.initialize(PlayerConf.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Player = youTubePlayer;
                Player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                Player.loadVideo("VwubeB2i5qM");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }

}
