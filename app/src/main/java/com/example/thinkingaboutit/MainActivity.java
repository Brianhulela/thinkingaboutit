package com.example.thinkingaboutit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArticlesRecyclerAdapter articlesRecyclerAdapter;
    ArrayList<Article> data;
    ExtendedFloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add(new Article("One article", "This is just a test to see if the article things work just find. Don't mind me at all!"));
        data.add(new Article("Two article", "This is just a test to see if the article things work just find. Don't mind me at all!"));
        data.add(new Article("Three article", "This is just a test to see if the article things work just find. Don't mind me at all!"));

        recyclerView = findViewById(R.id.allArticlesRecyclerview);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        articlesRecyclerAdapter = new ArticlesRecyclerAdapter(this, data);
        recyclerView.setAdapter(articlesRecyclerAdapter);

        floatingActionButton = findViewById(R.id.composeFloatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.constraintLayout, new CreateArticleFragment()).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}