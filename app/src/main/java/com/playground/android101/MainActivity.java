package com.playground.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.playground.android101.database.WordsDatabase;
import com.playground.android101.database.WordsDatabaseProvider;
import com.playground.android101.datasource.DataSourceDatabase;
import com.playground.android101.repository.WordsRepository;

public class MainActivity extends AppCompatActivity {

    private WordsRepository wordsRepository;

    private EditText wordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordEditText = findViewById(R.id.editText);

        findViewById(R.id.btnPersist).setOnClickListener(view -> persist(wordEditText.getText().toString()));
        findViewById(R.id.btnRetrieve).setOnClickListener(view -> showPersistedData());

        initialiseDatabase();
    }

    private void initialiseDatabase() {
        WordsDatabaseProvider databaseProvider = new WordsDatabaseProvider();
        WordsDatabase database = databaseProvider.getDatabase(this);
        DataSourceDatabase dataSource = new DataSourceDatabase(database.getWordsDao(), WordsDatabaseProvider.databaseWriteExecutor);
        wordsRepository = new WordsRepository(dataSource);
    }

    private void persist(String word) {
        if (word != null) wordsRepository.save(word);
    }

    private void showPersistedData() {
        wordsRepository.retrieveWord((retrievedWord) -> {
            String word = retrievedWord != null ? retrievedWord : "Nothing is stored";
            updateScreenText(word);
        });
    }

    private void updateScreenText(String newText) {
        runOnUiThread(() -> wordEditText.setText(newText));
    }

}