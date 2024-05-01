package com.example.quiz2app.presentation.category;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quiz2app.R;
import com.example.quiz2app.data.model.CategoryEnum;
import com.example.quiz2app.presentation.info.InfoActivity;
import com.example.quiz2app.presentation.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View{
    private CategoryContract.Presenter presenter;
    private ImageView infoPage;
    private List<ViewGroup> viewGroups;
    private List<TextView> texts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        presenter = new CategoryPresenter(this);
        clickCategory();
        findViewById(R.id.info).setOnClickListener(v -> {
                openInfoActivity();
        });
    }

    private void clickCategory() {
        findViewById(R.id.science).setOnClickListener(v -> {
            presenter.setSelectCategory(CategoryEnum.SCIENTIST, 0);
            openQuestionActivity();
        });

        findViewById(R.id.history).setOnClickListener(v -> {
            presenter.setSelectCategory(CategoryEnum.HISTORY, 1);
            openQuestionActivity();
        });

        findViewById(R.id.geography).setOnClickListener(v ->{
            presenter.setSelectCategory(CategoryEnum.GEOGRAPHY, 2);
            openQuestionActivity();
        });

        findViewById(R.id.computer).setOnClickListener(v ->{
            presenter.setSelectCategory(CategoryEnum.COMPUTER_SCIENCE, 3);
            openQuestionActivity();
        });

    }
    private void openQuestionActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openInfoActivity() {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

}