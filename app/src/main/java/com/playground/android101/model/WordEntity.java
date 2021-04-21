package com.playground.android101.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created on 20/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
@Entity
public class WordEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public final String word;

    public WordEntity(String word) {
        this.word = word;
    }
}
