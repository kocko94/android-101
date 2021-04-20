package com.playground.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.playground.android101.datasource.DataSource;
import com.playground.android101.datasource.DataSourceSharedPreferences;
import com.playground.android101.repository.WordsRepository;

public class MainActivity extends AppCompatActivity {

    private WordsRepository repository;

    private EditText wordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataSource dataSource = new DataSourceSharedPreferences(this);
        repository = new WordsRepository(dataSource);

        wordEditText = findViewById(R.id.editText);

        findViewById(R.id.btnPersist).setOnClickListener(view -> persist(wordEditText.getText().toString()));
        findViewById(R.id.btnRetrieve).setOnClickListener(view -> showPersistedData());
    }

    private void persist(String word) {
        if (word != null) repository.save(word);
    }

    private void showPersistedData() {
        repository.retrieveWord((retrievedWord) -> {
            String word = retrievedWord != null ? retrievedWord : "Nothing is stored";
            wordEditText.setText(word);
        });
    }

}