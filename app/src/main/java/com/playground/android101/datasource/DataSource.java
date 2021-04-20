package com.playground.android101.datasource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created on 18/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface DataSource {

    void save(@NonNull String word);

    @Nullable
    String retrieveWord();
}
