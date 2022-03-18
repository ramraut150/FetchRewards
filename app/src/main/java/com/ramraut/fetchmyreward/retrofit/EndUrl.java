package com.ramraut.fetchmyreward.retrofit;

import com.ramraut.fetchmyreward.model.Article;
import com.ramraut.fetchmyreward.response.FetchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndUrl {

    @GET("hiring.json")
    Call<List<Article>> getFetchReards();


}
