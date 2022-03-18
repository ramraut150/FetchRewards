package com.ramraut.fetchmyreward.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    //model class is responsible to get the data
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("listId")
    @Expose
    private String listId;

    @SerializedName("name")
    @Expose
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", listId='" + listId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
