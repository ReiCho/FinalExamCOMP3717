package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddPage(View view) {
        Intent intent = new Intent(getBaseContext(), AddActivity.class);
        startActivity(intent);
    }

    public void onClickViewPage(View view) {
        Intent intent = new Intent(getBaseContext(), ViewActivity.class);
        startActivity(intent);

    }
}
