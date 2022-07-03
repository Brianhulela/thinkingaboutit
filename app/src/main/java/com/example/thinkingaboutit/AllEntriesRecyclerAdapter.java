package com.example.thinkingaboutit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllEntriesRecyclerAdapter extends RecyclerView.Adapter<AllEntriesRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<Entry> data;

    public AllEntriesRecyclerAdapter(Context context, ArrayList<Entry> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AllEntriesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllEntriesRecyclerAdapter.ViewHolder holder, int position) {

        Entry entry = data.get(holder.getAdapterPosition());
        holder.titleTextview.setText(entry.title);

        holder.bookmarkImagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!entry.bookmark){
                    entry.bookmark = true;
                    int imageResource = context.getResources().getIdentifier("@drawable/ic_checked_bookmark", null, context.getPackageName());
                    Drawable res = context.getResources().getDrawable(imageResource);
                    holder.bookmarkImagebutton.setImageDrawable(res);
                }else {
                    entry.bookmark = false;
                    int imageResource = context.getResources().getIdentifier("@drawable/ic_unchecked_bookmark", null, context.getPackageName());
                    Drawable res = context.getResources().getDrawable(imageResource);
                    holder.bookmarkImagebutton.setImageDrawable(res);
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
        ImageButton bookmarkImagebutton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextview = itemView.findViewById(R.id.titleTextview);
            bookmarkImagebutton = itemView.findViewById(R.id.bookmarkImagebutton);
        }
    }
}
