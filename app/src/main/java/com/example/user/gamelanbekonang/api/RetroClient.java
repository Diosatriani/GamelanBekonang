package com.example.user.gamelanbekonang.api;

import com.example.user.gamelanbekonang.beans.Iklan;

/**
 * Created by Lenovo on 27/03/2018.
 */

public class RetroClient {
    /********
     * URLS
     *******/
//    private static final String ROOT_URL = "http://bekonang-store.000webhostapp.com/";

    /**
     * Get Retrofit Instance
     */
//    private static Retrofit getRetrofitInstance() {
//        return new Retrofit.Builder()
//                .baseUrl(ROOT_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }

    /**
     * Get API Service
     *
     * @return API Service
     */
//    public static ApiService getApiService() {
//        return getRetrofitInstance().create(ApiService.class);
//    }

    private Iklan[] iklans;

    public Iklan[] getAndroid() {
        return iklans;
    }

}
