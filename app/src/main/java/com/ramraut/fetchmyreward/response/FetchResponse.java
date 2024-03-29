package com.ramraut.fetchmyreward.response;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ramraut.fetchmyreward.model.Article;

import java.util.List;

public class FetchResponse {


    public List<Article>articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    @Override
    public String toString() {
        return "{" +
                "articles=" + articles + '}';
    }
}
