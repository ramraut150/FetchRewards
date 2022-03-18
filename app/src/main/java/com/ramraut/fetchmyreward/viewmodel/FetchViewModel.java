package com.ramraut.fetchmyreward.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ramraut.fetchmyreward.model.Article;
import com.ramraut.fetchmyreward.repository.FetchRepository;
import com.ramraut.fetchmyreward.response.FetchResponse;

import java.util.List;

public class FetchViewModel extends AndroidViewModel {

    private FetchRepository fetchRepository;
    private LiveData<List<Article>> fetchResponseLiveData;

    public FetchViewModel(@NonNull Application application) {
        super(application);

        fetchRepository = new FetchRepository();
        this.fetchResponseLiveData = fetchRepository.getFetchRewardLiveData();
    }



    public LiveData<List<Article>> getFetchResponseLiveData(){
        return fetchResponseLiveData;
    }

}
