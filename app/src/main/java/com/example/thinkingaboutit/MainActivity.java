package com.example.thinkingaboutit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArticlesRecyclerAdapter articlesRecyclerAdapter;
    ArrayList<Article> data;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        data = new ArrayList<>();
        data.add(new Article("Feeling really sad today!"));
        data.add(new Article("I passed all my exams"));
        data.add(new Article("If I could finish this year"));

        recyclerView = findViewById(R.id.allArticlesRecyclerview);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        articlesRecyclerAdapter = new ArticlesRecyclerAdapter(this, data);
        recyclerView.setAdapter(articlesRecyclerAdapter);


    }
}