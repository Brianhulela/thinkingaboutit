package com.example.thinkingaboutit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton likeButton;
    ImageButton bookmarkButton;
    boolean like = true;
    boolean bookmark = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = findViewById(R.id.likeButton);
        bookmarkButton = findViewById(R.id.bookmarkImagebutton);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popup_animation);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (like){
                    //likeButtonsLayout.startAnimation(animation);
                    likeButton.setBackgroundColor(Color.parseColor("#66BB6A"));
                    like = false;
                }else {
                    likeButton.setBackgroundColor(Color.parseColor("#A3A3A3"));
                    like = true;
                }
            }
        });

        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookmark){
                    String uri = "@drawable/ic_checked_bookmark";  // where myresource (without the extension) is the file
                    int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                    Drawable res = getResources().getDrawable(imageResource);
                    bookmarkButton.setImageDrawable(res);
                    bookmark = false;
                }else{
                    String uri = "@drawable/ic_unchecked_bookmark";  // where myresource (without the extension) is the file
                    int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                    Drawable res = getResources().getDrawable(imageResource);
                    bookmarkButton.setImageDrawable(res);
                    bookmark = true;
                }
            }
        });
    }
}