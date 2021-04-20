package com.playground.android101.datasource;

import androidx.annotation.NonNull;
import com.playground.android101.util.ResultCallback;

/**
 * Created on 18/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface DataSource {

    void save(@NonNull String word);

    void retrieveWord(ResultCallback<String> result);
}
