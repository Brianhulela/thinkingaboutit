package com.example.thinkingaboutit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CommentsRecyclerAdapter extends RecyclerView.Adapter<CommentsRecyclerAdapter.ViewHolder> {
    ArrayList<Comment> data;
    Context context;

    public CommentsRecyclerAdapter(ArrayList<Comment> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsRecyclerAdapter.ViewHolder holder, int position) {
        holder.commentTextview.setText(data.get(holder.getAdapterPosition()).commentText);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        MaterialTextView commentTextview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentTextview = itemView.findViewById(R.id.commentTextview);
        }
    }
}
