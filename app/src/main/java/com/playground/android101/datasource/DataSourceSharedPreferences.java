package com.playground.android101.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.playground.android101.util.ResultCallback;

/**
 * Created on 18/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DataSourceSharedPreferences implements DataSource {

    private final SharedPreferences sharedPreferences;

    private final String KEY_WORD = "UniqueKeyForMyWorld";

    public DataSourceSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("Android101", Context.MODE_PRIVATE);
    }

    @Override
    public void save(@NonNull String word) {
        sharedPreferences
                .edit()
                .putString(KEY_WORD, word)
                .apply();
    }

    @Override
    public void retrieveWord(ResultCallback<String> callback) {
        String word = sharedPreferences.getString(KEY_WORD, null);
        callback.setResult(word);
    }
}
