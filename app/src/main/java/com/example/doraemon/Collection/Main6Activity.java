package com.example.doraemon.Collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doraemon.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragmentX;

public class Main6Activity extends Fragment {
    private static final String Tag = Main6Activity.class.getSimpleName();
    private YouTubePlayerFragmentX youTubePlayerFragmentX;
    private YouTubePlayer Player;
    Button button[] = new Button[12];
    TextView textView[] = new TextView[12];
    int ID[] = new int[]{R.id.View,R.id.View1,R.id.View2,R.id.View3,R.id.View4,R.id.View5,R.id.View6,R.id.View7,R.id.View8,R.id.View9,R.id.View10,R.id.View11};
    String s[] = new String[]{"NiG7k20ocGI","2q8PVSaEMUw","I3BRMn1s-ys","vPaBMuGpATk","X7mVKH2iS6s","39U43rbJ4Xo","hY7vFpFBYYM","zBx7FyllEgQ","tPUB1Uah-YM","iVUpzfNKWNc","gp2sUgKLSuE","wBnHesjuf68"};
    String Title[] = new String[]{"Nobita and The Steel Troops","The Secret of the Gadget Museum","Nobita and the Sultan of Bidopia","Galaxy Super Express","Nobita in the New Haunt of Evil","Nobita's Dorabian Nights","Exciting Adventure","Jadoo Mantar and Jahnoom","Nobita aur khel khilona Bhool bhulaiya","Nobita the Explorer bow!bow!","Nobita and the Three magical Swordsmen","Nobita drifts in the universe"};
    static int i = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(final LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_main6,parent,false);

        button[0] = (Button)v.findViewById (R.id.button);
        textView[0] = (TextView)v.findViewById (R.id.text);
        button[1] = (Button)v.findViewById (R.id.button1);
        textView[1] = (TextView)v.findViewById (R.id.text1);
        button[2] = (Button)v.findViewById (R.id.button2);
        textView[2] = (TextView)v.findViewById (R.id.text2);
        button[3] = (Button)v.findViewById (R.id.button3);
        textView[3] = (TextView)v.findViewById (R.id.text3);
        button[4] = (Button)v.findViewById (R.id.button4);
        textView[4] = (TextView)v.findViewById (R.id.text4);
        button[5] = (Button)v.findViewById (R.id.button5);
        textView[5] = (TextView)v.findViewById (R.id.text5);
        button[6] = (Button)v.findViewById (R.id.button6);
        textView[6] = (TextView)v.findViewById (R.id.text6);
        button[7] = (Button)v.findViewById (R.id.button7);
        textView[7] = (TextView)v.findViewById (R.id.text7);
        button[8] = (Button)v.findViewById (R.id.button8);
        textView[8] = (TextView)v.findViewById (R.id.text8);
        button[9] = (Button)v.findViewById (R.id.button9);
        textView[9] = (TextView)v.findViewById (R.id.text9);
        button[10] = (Button)v.findViewById (R.id.button10);
        textView[10] = (TextView)v.findViewById (R.id.text10);
        button[11] = (Button)v.findViewById (R.id.button11);
        textView[11] = (TextView)v.findViewById (R.id.text11);

        i=0;
        while(i<12) {
            textView[i].setText(Title[i]);
            i++;
        }

        button[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initializeYouTubePlayer(0);
                    }
        });
        button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(1);
            }
        });
        button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(2);
            }
        });
        button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(3);
            }
        });
        button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(4);
            }
        });
        button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(5);
            }
        });
        button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(6);
            }
        });
        button[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(7);
            }
        });
        button[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(8);
            }
        });
        button[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(9);
            }
        });
        button[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(10);
            }
        });
        button[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer(11);
            }
        });


            return v;
    }

    private void initializeYouTubePlayer(final int j){
        youTubePlayerFragmentX = (YouTubePlayerFragmentX)getChildFragmentManager().findFragmentById(ID[j]);
        if(youTubePlayerFragmentX == null)
            return;
        youTubePlayerFragmentX.initialize(PlayerConf.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Player = youTubePlayer;
                Player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                Player.loadVideo(s[j]);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
