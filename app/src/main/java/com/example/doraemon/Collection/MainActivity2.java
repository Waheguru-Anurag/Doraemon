package com.example.doraemon.Collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doraemon.R;
import com.example.doraemon.ui.Anywhere_Door;
import com.example.doraemon.ui.Login_Saviour;
import com.example.doraemon.ui.Time_Machine;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem tab1,tab2,tab3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2main);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout1);
        tab1 = (TabItem) findViewById(R.id.tab_1);
        tab2 = (TabItem) findViewById(R.id.tab_2);
        tab3 = (TabItem) findViewById(R.id.tab_3);
        button = (Button)findViewById(R.id.button_1);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0)
                    openMainActivity(0);
                else if(tab.getPosition() == 1)
                    openMainActivity(1);
                else if(tab.getPosition() == 2)
                    openMainActivity(2);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openMainActivity(int i){
        Intent intent;
        switch (i){
            case 0:
                intent = new Intent(this, Time_Machine.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, Anywhere_Door.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, Login_Saviour.class);
                startActivity(intent);
                break;
        }
    }

    public void openActivity(){
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
    }
}
