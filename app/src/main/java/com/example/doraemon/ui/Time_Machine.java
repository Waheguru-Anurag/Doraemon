package com.example.doraemon.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doraemon.R;
import com.example.doraemon.ui.Time_Machine_Model.Post;

import java.util.GregorianCalendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Time_Machine extends AppCompatActivity {
    private TextView textView;
    Time_Machine_API time_machine_api;
    static String s = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_timemachine);
        Button button = findViewById(R.id.btn_1);
        Button button1 = findViewById(R.id.btn_2);
        textView = findViewById(R.id.text_Time_Machine);
        time_machine_api = Time_Machine_Client.getClient().create(Time_Machine_API.class);
        GregorianCalendar gc = new GregorianCalendar();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "";
                fetchData();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = randBetween(1600, 2018);

                gc.set(gc.YEAR, year);

                int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

                gc.set(gc.DAY_OF_YEAR, dayOfYear);

                s = "/" + (gc.get(gc.MONTH)+1) + "/" + gc.get(gc.DAY_OF_MONTH);
                fetchData();
            }
        });
    }

        private void fetchData(){
            Call<Post> call = time_machine_api.getpostData(s);
            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Post post = response.body();
                            int i = randBetween(0,post.getData().getEvents().size());
                            String content = "";
                            content += "Date: " + post.getDate() + "\n";
                            content+="Year: "+ post.getData().getEvents().get(i).getYear() + "\n";
                            content+=post.getData().getEvents().get(i).getText();
                            textView.setText(content);
                        }
                    } else {
                        Toast.makeText(Time_Machine.this, "Invalid Zip Code", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                    Toast.makeText(Time_Machine.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}