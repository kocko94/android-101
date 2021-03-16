package com.playground.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setResultText();
    }

    private void setResultText() {
        String providedResult = getIntent().getStringExtra(MainActivity.EXTRA_KEY_RESULT);
        TextView resultView = findViewById(R.id.resultView);
        resultView.setText(providedResult);
    }
}