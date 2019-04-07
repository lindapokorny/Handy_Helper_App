package com.pursuit.handy_helper_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    private ImageView splashImage;

    private static int SPLASH_SCREEN_TIMER = 5500;
    private Intent toMainActivityIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImage = findViewById(R.id.splash_image);
        Glide.with(SplashActivity.this)
                .load(R.drawable.construction)
                .into(splashImage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toMainActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(toMainActivityIntent);
                finish();
            }
        }, SPLASH_SCREEN_TIMER);
    }
}
