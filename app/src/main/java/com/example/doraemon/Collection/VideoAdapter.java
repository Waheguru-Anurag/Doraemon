package com.example.doraemon.Collection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doraemon.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragmentX;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<videoitem> exampleList;
    videoitem currentItem;
    private YouTubePlayerFragmentX youTubePlayerFragmentX;
    private YouTubePlayer Player;
    FragmentManager fm ;


    public class VideoViewHolder extends RecyclerView.ViewHolder{
        Button button;
        VideoViewHolder(View itemView){
            super(itemView);
            button = (Button) itemView.findViewById(R.id.bn);
        }
    }

    VideoAdapter(List<videoitem> videoList,FragmentManager fm){
        this.exampleList = videoList;
        this.fm = fm;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_items,parent,false);
        return new VideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder holder, int position) {
        currentItem = exampleList.get(position);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeYouTubePlayer();
            }
        });
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    private void initializeYouTubePlayer(){
        youTubePlayerFragmentX = (YouTubePlayerFragmentX) fm.findFragmentById(R.id.youtube_video);
        if(youTubePlayerFragmentX == null)
            return;
        youTubePlayerFragmentX.initialize(PlayerConf.API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Player = youTubePlayer;
                Player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                Player.loadVideo(currentItem.VideoResource);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
