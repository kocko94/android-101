package com.playground.android101.util;

import androidx.annotation.Nullable;

/**
 * Created on 27/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface ResultCallback<T> {
    void setResult(@Nullable T result);
}
