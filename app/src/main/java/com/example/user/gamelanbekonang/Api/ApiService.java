package com.example.user.gamelanbekonang.Api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/v1/iklan")
    Call<RetroClient> getJSON();
}
