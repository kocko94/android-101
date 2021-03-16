package com.playground.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_KEY_RESULT = "resultKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(v -> startResultActivity("1"));
    }

    private void startResultActivity(String result) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_KEY_RESULT, result);
        startActivity(intent);
    }
}