package com.playground.android101.datasource;

import com.playground.android101.model.DadJoke;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created on 01/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public interface DadJokesApi {

    @Headers({"Accept: application/json"})
    @GET("/")
    Call<DadJoke> getJoke();

}