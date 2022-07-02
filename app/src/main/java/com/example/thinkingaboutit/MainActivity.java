package com.example.thinkingaboutit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton likeButton;
    ConstraintLayout likeButtonsLayout;
    boolean like = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = findViewById(R.id.likeButton);
        likeButtonsLayout = findViewById(R.id.likeButtonsLayout);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.popup_animation);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (like){
                    //likeButtonsLayout.startAnimation(animation);
                    likeButtonsLayout.setVisibility(View.VISIBLE);
                    like = false;
                }else {
                    likeButtonsLayout.setVisibility(View.GONE);
                    like = true;
                }
            }
        });
    }
}