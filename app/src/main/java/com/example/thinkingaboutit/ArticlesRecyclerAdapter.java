package com.example.thinkingaboutit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<Article> data;

    public ArticlesRecyclerAdapter(Context context, ArrayList<Article> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ArticlesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesRecyclerAdapter.ViewHolder holder, int position) {

        Article article = data.get(holder.getAdapterPosition());
        holder.titleTextview.setText(article.title);

        holder.bookmarkImagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!article.bookmark){
                    article.bookmark = true;
                    int imageResource = context.getResources().getIdentifier("@drawable/ic_checked_bookmark", null, context.getPackageName());
                    Drawable res = context.getResources().getDrawable(imageResource);
                    holder.bookmarkImagebutton.setButtonDrawable(res);
                }else {
                    article.bookmark = false;
                    int imageResource = context.getResources().getIdentifier("@drawable/ic_unchecked_bookmark", null, context.getPackageName());
                    Drawable res = context.getResources().getDrawable(imageResource);
                    holder.bookmarkImagebutton.setButtonDrawable(res);
                }
            }
        });

        holder.likeCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!article.like){
                    article.like = true;
                    int imageResource = context.getResources().getIdentifier("@drawable/ic_liked", null, context.getPackageName());
                    Drawable res = context.getResources().getDrawable(imageResource);
                    holder.likeCheckbox.setButtonDrawable(res);
                }else {
                    article.like = false;
                    int imageResource = context.getResources().getIdentifier("@drawable/ic_unlike", null, context.getPackageName());
                    Drawable res = context.getResources().getDrawable(imageResource);
                    holder.likeCheckbox.setButtonDrawable(res);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        MaterialTextView titleTextview;
        MaterialCheckBox likeCheckbox;
        MaterialCheckBox bookmarkImagebutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextview = itemView.findViewById(R.id.titleTextview);
            bookmarkImagebutton = itemView.findViewById(R.id.bookmarkImagebutton);
            likeCheckbox = itemView.findViewById(R.id.likeCheckbox);
        }
    }
}
