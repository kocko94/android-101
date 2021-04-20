package com.playground.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.playground.android101.datasource.DataSource;
import com.playground.android101.datasource.DataSourceSharedPreferences;

public class MainActivity extends AppCompatActivity {

    private DataSource dataSource;

    private EditText wordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new DataSourceSharedPreferences(this);
        wordEditText = findViewById(R.id.editText);

        findViewById(R.id.btnPersist).setOnClickListener(view -> persist(wordEditText.getText().toString()));
        findViewById(R.id.btnRetrieve).setOnClickListener(view -> showPersistedData());
    }

    private void persist(String word) {
        if (word != null) dataSource.save(word);
    }

    private void showPersistedData() {
        String retrievedWord = dataSource.retrieveWord();
        String word = retrievedWord != null ? retrievedWord : "Nothing is stored";
        wordEditText.setText(word);
    }

}