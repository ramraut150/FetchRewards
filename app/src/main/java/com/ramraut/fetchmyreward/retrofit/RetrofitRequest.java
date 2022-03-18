package com.ramraut.fetchmyreward.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ramraut.fetchmyreward.constant.StartUrl.fetchRewardsUrl;

public class RetrofitRequest {

    private static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(fetchRewardsUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
