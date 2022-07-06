package com.example.thinkingaboutit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class LikesRecyclerAdapter extends RecyclerView.Adapter<LikesRecyclerAdapter.ViewHolder> {
    ArrayList<Like> data;
    Context context;

    public LikesRecyclerAdapter(ArrayList<Like> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.like, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.likeTextview.setText(data.get(holder.getAdapterPosition()).name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        MaterialTextView likeTextview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            likeTextview = itemView.findViewById(R.id.likeTextview);
        }
    }
}
