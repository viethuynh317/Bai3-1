package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvCounter = findViewById(R.id.tv_counter);
        Intent intent = getIntent();
        if(intent != null){
            String data = intent.getStringExtra("data");
            tvCounter.setText(data);
        }
    }
}