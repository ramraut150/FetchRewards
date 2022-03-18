package com.ramraut.fetchmyreward.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ramraut.fetchmyreward.R;
import com.ramraut.fetchmyreward.adapter.FetchRewardAdapter;
import com.ramraut.fetchmyreward.model.Article;
import com.ramraut.fetchmyreward.viewmodel.FetchViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FetchReward extends AppCompatActivity implements FetchRewardAdapter.itemClicked {

    private static final String TAG = FetchReward.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private LinearLayoutManager layoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    FetchViewModel fetchViewModel;
    private FetchRewardAdapter fetchRewardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_reward);

        init();
        getArticles();
    }

    private void getArticles() {
        fetchViewModel.getFetchResponseLiveData().observe(this, fetchResponse -> {
//            if(fetchResponse != null && fetchResponse.getArticles() != null && !fetchResponse.getArticles().isEmpty()){
                if(fetchResponse != null){
                progressBar.setVisibility(View.GONE);
                List<Article> articleList = fetchResponse;

                articleArrayList.addAll(articleList);
                fetchRewardAdapter.notifyDataSetChanged();
            }
        });
    }

    private void init(){
        progressBar = findViewById(R.id.progressID);
        recyclerView = findViewById(R.id.recyclerid);
        layoutManager = new LinearLayoutManager(FetchReward.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        fetchRewardAdapter = new FetchRewardAdapter(FetchReward.this, articleArrayList, this);
        recyclerView.setAdapter(fetchRewardAdapter);
        fetchViewModel = ViewModelProviders.of(this).get(FetchViewModel.class);

    }


    @Override
    public void clickedOnReward(Article article) {
        Toast.makeText(this, "You cliked on List ID: "+ article.getId(), Toast.LENGTH_SHORT).show();
    }
}