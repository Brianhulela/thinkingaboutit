package com.example.thinkingaboutit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookmarkedFragment extends Fragment {

    MainActivity mainActivity;
    ArrayList<Article> data;
    ArrayList<Article> bookmarkedArticles;

    RecyclerView bookmarkedRecyclerview;
    RecyclerView.LayoutManager layoutManager;
    ArticlesRecyclerAdapter bookmarkedArticlesRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bookmarked_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        data = mainActivity.data;
        bookmarkedArticles = new ArrayList<>();
        for (Article article : data){
            if (article.bookmark){
                bookmarkedArticles.add(article);
            }
        }

        bookmarkedRecyclerview = view.findViewById(R.id.bookmarkedRecyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        bookmarkedArticlesRecyclerAdapter = new ArticlesRecyclerAdapter(getContext(), bookmarkedArticles);
        bookmarkedRecyclerview.setLayoutManager(layoutManager);
        bookmarkedRecyclerview.setAdapter(bookmarkedArticlesRecyclerAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mainActivity.fm.getBackStackEntryCount()==0) {
            mainActivity.appnameTextview.setText(R.string.app_name);
        }
    }
}
