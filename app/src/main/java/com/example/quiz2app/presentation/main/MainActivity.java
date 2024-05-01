package com.example.quiz2app.presentation.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quiz2app.R;
import com.example.quiz2app.data.model.QuestionData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    private MainPresenter presenter;
    private TextView questionText;
    private List<ViewGroup> variants;
    private List<ImageView> images;
    private List<TextView> variantText;
    private TextView next;
    private TextView finish;
    private TextView skip;
    private LinearLayout back;
    private AlertDialog dialog;
    private View view;
    private ImageView image;
    private AlertDialog dialogBack;
    private View viewBack;
    private TextView noFinish;
    private TextView yesFinish;
    private TextView trueAnswer;
    private TextView wrongAnswer;
    private TextView toHome;
    private TextView refresh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        presenter = new MainPresenter(this);

    }

    @Override
    public void replaceImages(int pos) {
        images.get(pos).setImageResource(R.drawable.check);
        variants.get(pos).setBackgroundResource(R.drawable.variant_bg);
    }

    @Override
    public void clearAll(int pos) {
        images.get(pos).setImageResource(R.drawable.uncheck);
        variants.get(pos).setBackgroundResource(R.drawable.bg_uncheck_variant);
    }

    @SuppressLint("SetTextI18n")
    public void loadQuestionData(QuestionData question, int testNumber) {
        image = findViewById(R.id.main_image);
        questionText.setText(testNumber + ". " + question.getQuestion());
        for (int i = 0; i < variantText.size(); i++) {
            variantText.get(i).setText(question.getVarians().get(i));
        }
        image.setImageResource(question.getImage());
    }

    @Override
    public void showDialog() {
        view = LayoutInflater.from(this).inflate(R.layout.dialog, null, false);
        dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(false)
                .create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogToHomePage();
        refresh();
        dialog.show();
    }

    @Override
    public void showBackDialog() {
        viewBack = LayoutInflater.from(this).inflate(R.layout.back_dialog, null, false);
        dialogBack = new AlertDialog.Builder(this)
                .setView(viewBack)
                .setCancelable(false)
                .create();

        dialogBack.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        yesFinish();
        noFinish();
        dialogBack.show();
    }

    @Override
    public void setTrueAndWrong(int trueAnswers, int wrongAnswers) {
        trueAnswer = view.findViewById(R.id.trueAnswer);
        wrongAnswer = view.findViewById(R.id.wrongAnswer);
        trueAnswer.setText(String.valueOf(trueAnswers));
        wrongAnswer.setText(String.valueOf(wrongAnswers));
        Log.d("TTT", String.valueOf(trueAnswers)+ String.valueOf(wrongAnswers));
    }

    @Override
    public void setColorNext() {
        next.setBackgroundResource(R.drawable.bg_btn);
        skip.setVisibility(View.INVISIBLE);
    }

    @Override
    public void clearColorNext() {
        next.setBackgroundResource(R.drawable.unclick_next_bg);
        skip.setVisibility(View.VISIBLE);
    }

    @Override
    public void setVisibly() {
        next.setVisibility(View.INVISIBLE);
        skip.setVisibility(View.INVISIBLE);
        finish.setVisibility(View.VISIBLE);
    }

    @Override
    public void clearVisibly() {
        next.setVisibility(View.VISIBLE);
        skip.setVisibility(View.VISIBLE);
        finish.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setClickable() {
        for (int i = 0; i < variants.size(); i++) {
            variants.get(i).setClickable(false);
        }
    }


    @Override
    public void clearClickable() {
        for (int i = 0; i < variants.size(); i++) {
            variants.get(i).setClickable(true);
        }
    }

    private void loadView() {
        questionText = findViewById(R.id.textQuestion);
        next = findViewById(R.id.next);
        skip = findViewById(R.id.skip);
        finish = findViewById(R.id.finish);
        back = findViewById(R.id.backToMain);


        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.variant_1));
        variants.add(findViewById(R.id.variant_2));
        variants.add(findViewById(R.id.variant_3));
        variants.add(findViewById(R.id.variant_4));

        images = new ArrayList<>(4);
        images.add(findViewById(R.id.variant_image_1));
        images.add(findViewById(R.id.variant_image_2));
        images.add(findViewById(R.id.variant_image_3));
        images.add(findViewById(R.id.variant_image_4));

        variantText = new ArrayList<>(4);
        variantText.add(findViewById(R.id.variant_text_1));
        variantText.add(findViewById(R.id.variant_text_2));
        variantText.add(findViewById(R.id.variant_text_3));
        variantText.add(findViewById(R.id.variant_text_4));

        for (int i = 0; i < variants.size(); i++) {
            int index = i;
            variants.get(i).setOnClickListener(v -> {
                presenter.selectAnswer(index);
            });
        }

        next.setOnClickListener(v -> {
            presenter.clickNextButton();
        });

        skip.setOnClickListener(v -> {
            presenter.clickSkipButton();
        });

        finish.setOnClickListener(v -> {
            presenter.finishSkipButton();
        });

        back.setOnClickListener(v -> {
            showBackDialog();
        });


    }

    private void dialogToHomePage() {
        toHome = view.findViewById(R.id.toHome);
        toHome.setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });
    }
    private void refresh() {
        refresh = view.findViewById(R.id.refresh);
        refresh.setOnClickListener(v -> {
            presenter.loadQuestions();
            presenter.getQuestionById();
            dialog.dismiss();
        });
    }

    private void yesFinish() {
        yesFinish = viewBack.findViewById(R.id.yesFinish);
        yesFinish.setOnClickListener(v -> {
            dialogBack.dismiss();
            presenter.finishSkipButton();
        });
    }

    private void noFinish() {
        noFinish = viewBack.findViewById(R.id.noFinish);
        noFinish.setOnClickListener(v -> {dialogBack.dismiss();});
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

}