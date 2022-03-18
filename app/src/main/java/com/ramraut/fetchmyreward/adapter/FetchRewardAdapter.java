package com.ramraut.fetchmyreward.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramraut.fetchmyreward.R;
import com.ramraut.fetchmyreward.model.Article;
import com.ramraut.fetchmyreward.model.Article;
import com.ramraut.fetchmyreward.model.Article;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FetchRewardAdapter extends RecyclerView.Adapter<FetchRewardAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<Article> articleArrayList = new ArrayList<Article>();
    private itemClicked itemclicked;

    public FetchRewardAdapter(Context context, ArrayList<Article> articleArrayList, itemClicked itemclicked) {
        this.context = context;
        this.articleArrayList = articleArrayList;
        this.itemclicked = itemclicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_display,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FetchRewardAdapter.ViewHolder holder, int position) {

        Article article = articleArrayList.get(position);
        holder.listId.setText("ID: " + article.getListId());
        holder.name.setText("Name: " + article.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemclicked.clickedOnReward(articleArrayList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView listId;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listId = itemView.findViewById(R.id.listId);
            name = itemView.findViewById(R.id.nameId);


        }
    }
    
    public interface itemClicked{
        public void clickedOnReward(Article article);

    }
}
