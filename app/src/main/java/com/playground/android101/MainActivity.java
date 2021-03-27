package com.playground.android101;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener((v -> showMyDialog()));
    }

    private void showMyDialog() {
        new AlertDialog.Builder(this)
                .setTitle("My title")
                .setMessage("My long and unique message...")
                .setPositiveButton("Positive", (dialog, which) -> Toast.makeText(this, "Positive button was clicked", Toast.LENGTH_LONG).show())
                .setNegativeButton("Negative", (dialog, which) -> Toast.makeText(this, "Negative button was clicked", Toast.LENGTH_LONG).show())
                .setCancelable(false)
                .create()
                .show();
    }
}