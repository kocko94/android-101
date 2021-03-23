package com.playground.android101.model;

/**
 * Created on 23/03/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DummyData {
    private final String imageUrl;
    private final String title;

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    private final String description;

    public DummyData(String imageUrl, String title, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }
}
