package com.ramraut.fetchmyreward.repository;

import androidx.lifecycle.MutableLiveData;

import com.ramraut.fetchmyreward.model.Article;
import com.ramraut.fetchmyreward.retrofit.EndUrl;
import com.ramraut.fetchmyreward.retrofit.RetrofitRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchRepository {

    // private static final String TAG = FetchRepository.class.getSimpleName();
    private final EndUrl apiRequest;


    public FetchRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(EndUrl.class);
    }

    MutableLiveData<List<Article>> data = new MutableLiveData<>();

    public MutableLiveData<List<Article>> getFetchRewardLiveData() {
        apiRequest.getFetchReards().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                //if success
                if (response.body() != null) {
                    List<Article> temp = response.body();
                    List<Article> temp2 = new ArrayList<Article>();
                    temp.forEach(c -> {
                        if (c.getName() != null && !c.getName().equalsIgnoreCase("null") && !c.getName().equalsIgnoreCase("")) {
                            temp2.add(c);
                        }
                        Collections.sort(temp2, Comparator.comparing((Article a)-> a.getListId()).thenComparing((Article a)-> removeSpace(a.getName())));

                    });
                    data.setValue(temp2);
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;


    }

    private int removeSpace(String name){
        String num = name.replaceAll("Item ", "");
        return Integer.parseInt(num);
    }
}
