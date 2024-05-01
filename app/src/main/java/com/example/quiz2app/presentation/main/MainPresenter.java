package com.example.quiz2app.presentation.main;

import com.example.quiz2app.data.model.QuestionData;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;
    private final MainContract.Model model;
    private int selectAnswer = -1;
    private List<QuestionData> ls;
    private int currentQuestion = 0;
    private int trueAnswers;
    private int wrongAnswers;

    private final int testNums = 10;

    MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();

        loadQuestions();
        getQuestionById();
    }
    @Override
    public void selectAnswer(int pos) {
        if (selectAnswer == pos) return;
        if (selectAnswer > -1) view.clearAll(selectAnswer);
        view.replaceImages(pos);
        view.setColorNext();
        selectAnswer = pos;
        if (ls.get(currentQuestion).getAnswer().equals(ls.get(currentQuestion).getVarians().get(selectAnswer))) {
            ls.get(currentQuestion).setAns(1);
        }else ls.get(currentQuestion).setAns(0);
    }

    @Override
    public void loadQuestions() {
        ls = model.getSelectCategory();
    }

    @Override
    public void getQuestionById() {
        view.loadQuestionData(ls.get(currentQuestion), currentQuestion + 1);
    }

    @Override
    public void clickNextButton() {
        if (currentQuestion + 1 == testNums) {
            view.setVisibly();
            view.setClickable();
            return;
        }
        if (selectAnswer == -1) return;
        currentQuestion++;
        getQuestionById();
        view.clearAll(selectAnswer);
        selectAnswer = -1;
        view.clearColorNext();

    }

    @Override
    public void clickSkipButton() {

        if (currentQuestion + 1 == testNums) {
            view.setVisibly();
            view.setClickable();
            return;
        }

        if (selectAnswer != -1) {
            view.clearAll(selectAnswer);
            view.clearColorNext();
            selectAnswer = -1;
        }
        ls.get(currentQuestion).setAns(0);
        currentQuestion++;
        getQuestionById();
    }

    @Override
    public void finishSkipButton() {
        view.showDialog();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getAns() == 1) trueAnswers++;
            else wrongAnswers++;
        }
        view.setTrueAndWrong(trueAnswers,wrongAnswers);
        currentQuestion = 0;
        trueAnswers = 0;
        wrongAnswers = 0;
        if (selectAnswer != -1) {
            view.clearAll(selectAnswer);
            selectAnswer = -1;
            view.clearColorNext();
        }
        view.clearVisibly();
        view.clearClickable();
    }

}

