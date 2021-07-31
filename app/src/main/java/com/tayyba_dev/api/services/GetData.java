package com.tayyba_dev.api.services;

import com.tayyba_dev.api.model.Hits;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetData {

    String baseur="https://simplifiedcoding.net/demos/";

    @GET("marvel")

    Call<List<Hits>> getResult();


}
