package com.playground.android101.repository;

import com.playground.android101.datasource.DataSource;
import com.playground.android101.util.ResultCallback;

/**
 * Created on 28/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class WordsRepository {

    private final DataSource wordsDataSource;

    public WordsRepository(DataSource wordsDataSource) {
        this.wordsDataSource = wordsDataSource;
    }

    public void save(String word) {
        wordsDataSource.save(word);
    }

    public void retrieveWord(ResultCallback<String> result) {
        wordsDataSource.retrieveWord(result);
    }
}
