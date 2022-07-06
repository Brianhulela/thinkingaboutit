package com.example.thinkingaboutit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArticlesRecyclerAdapter articlesRecyclerAdapter;
    ArrayList<Article> data;
    ExtendedFloatingActionButton floatingActionButton;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton navigationImagebutton;

    ImageButton accountImagebutton;
    MaterialTextView appnameTextview;

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appnameTextview = findViewById(R.id.appnameTextview);

        data = new ArrayList<>();
        Article article = new Article("One article", "This is just a test to see if the article things work just find. Don't mind me at all!");
        Article article1 = new Article("Two article", "This is just a test to see if the article things work just find. Don't mind me at all!");
        Article article2 = new Article("Three article", "This is just a test to see if the article things work just find. Don't mind me at all!");
        data.add(article);
        data.add(article1);
        data.add(article2);


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
                fragmentTransaction.replace(R.id.replaceConstraintlayout, new CreateArticleFragment()).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        navigationImagebutton = findViewById(R.id.navigateImagebutton);
        navigationImagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            // Handle menu item selected
            openFragment(menuItem.getTitle().toString());
            menuItem.isChecked();
            drawerLayout.close();
            return true;
        });

        accountImagebutton = findViewById(R.id.accountImagebutton);
        accountImagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment("account");
            }
        });

    }

    public void openFragment(String fragmentName){

        if(fm.getBackStackEntryCount()>0) {
            fm.popBackStack();
        }
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        switch(fragmentName) {
            case "bookmarked":
                fragmentTransaction.replace(R.id.replaceConstraintlayout, new BookmarkedFragment()).addToBackStack(null);
                appnameTextview.setText("bookmarks");
                break;
            case "liked":
                fragmentTransaction.replace(R.id.replaceConstraintlayout, new LikedFragment()).addToBackStack(null);
                appnameTextview.setText("liked");
                break;
            case "settings":
                fragmentTransaction.replace(R.id.replaceConstraintlayout, new SettingsFragment()).addToBackStack(null);
                appnameTextview.setText("settings");
                break;
            case "account":
                fragmentTransaction.replace(R.id.replaceConstraintlayout, new AccountFragment()).addToBackStack(null);
                appnameTextview.setText("account");
                break;
        }
        fragmentTransaction.commit();
    }

}