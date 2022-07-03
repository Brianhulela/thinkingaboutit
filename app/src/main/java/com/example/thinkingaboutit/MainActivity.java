package com.example.thinkingaboutit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AllEntriesRecyclerAdapter allEntriesRecyclerAdapter;
    ArrayList<Entry> data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add(new Entry("Feeling really sad today!"));
        data.add(new Entry("I passed all my exams"));
        data.add(new Entry("If I could finish this year"));

        recyclerView = findViewById(R.id.allCardsRecyclerview);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        allEntriesRecyclerAdapter = new AllEntriesRecyclerAdapter(this, data);
        recyclerView.setAdapter(allEntriesRecyclerAdapter);

    }
}