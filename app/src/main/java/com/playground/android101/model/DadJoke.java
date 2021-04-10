package com.playground.android101.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 07/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DadJoke {
    private String id;
    @SerializedName("joke")
    private String funnyJoke;
    private int status;

    public DadJoke(String id, String funnyJoke, int status) {
        this.id = id;
        this.funnyJoke = funnyJoke;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunnyJoke() {
        return funnyJoke;
    }

    public void setFunnyJoke(String funnyJoke) {
        this.funnyJoke = funnyJoke;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
