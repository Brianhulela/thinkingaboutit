package com.example.thinkingaboutit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LikedFragment extends Fragment {

    MainActivity mainActivity;
    ArrayList<Article> data;
    ArrayList<Article> likedArticles;

    RecyclerView likedRecyclerview;
    RecyclerView.LayoutManager layoutManager;
    ArticlesRecyclerAdapter likedArticlesRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liked_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        data = mainActivity.data;
        likedArticles = new ArrayList<>();
        for (Article article : data){
            if (article.like){
                likedArticles.add(article);
            }
        }

        likedRecyclerview = view.findViewById(R.id.likedRecyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        likedArticlesRecyclerAdapter = new ArticlesRecyclerAdapter(getContext(), likedArticles);
        likedRecyclerview.setLayoutManager(layoutManager);
        likedRecyclerview.setAdapter(likedArticlesRecyclerAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mainActivity.fm.getBackStackEntryCount()==0) {
            mainActivity.appnameTextview.setText(R.string.app_name);
        }
    }
}
