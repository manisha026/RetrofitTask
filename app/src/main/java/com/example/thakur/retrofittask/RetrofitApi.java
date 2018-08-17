package com.example.thakur.retrofittask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Thakur on 6/26/2018.
 */

public class RetrofitApi {

    public static RetrofitApi retrofitApi;
    public static Retrofit retrofit;

    public static Retrofit getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://infosif.com/logistix/index.php/api/user/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
