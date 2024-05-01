package com.example.quiz2app.presentation.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.quiz2app.R;
import com.example.quiz2app.presentation.category.CategoryActivity;

import kotlinx.coroutines.flow.Flow;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);

    }
}