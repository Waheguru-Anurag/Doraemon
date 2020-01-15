package com.example.doraemon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doraemon.R;

public class Login_Saviour extends AppCompatActivity {
    public static long h;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__sviour);
        editText = findViewById(R.id.edit_text);
        Button button = findViewById(R.id.button_3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = Long.parseLong(editText.getText().toString().trim());
                openActivity();
            }
        });
    }

    public void openActivity(){
        Intent intent = new Intent(this,Saviour.class);
        intent.putExtra("Extra",h);
        startActivity(intent);
    }
}
