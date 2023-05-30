package com.example.animationrotatestickman;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView stickmanImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stickmanImageView = findViewById(R.id.stickman);
    }

    public void startRotatingAnimation(View view) {
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(stickmanImageView, "translationX", 0, 500);
        translationXAnimator.setDuration(2000);
        translationXAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        translationXAnimator.setRepeatMode(ObjectAnimator.REVERSE);

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(stickmanImageView, "rotation", 0, 360);
        rotationAnimator.setDuration(1000);
        rotationAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        rotationAnimator.setRepeatMode(ObjectAnimator.RESTART);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationXAnimator, rotationAnimator);
        animatorSet.start();
    }
}
