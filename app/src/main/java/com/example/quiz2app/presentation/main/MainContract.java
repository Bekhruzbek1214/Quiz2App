package com.example.quiz2app.presentation.main;

import com.example.quiz2app.data.model.QuestionData;

import java.util.List;

public interface MainContract {

    interface View {
        void replaceImages(int pos);
        void clearAll(int pos);
        void loadQuestionData(QuestionData question, int testNumber);
        void showDialog();
        void showBackDialog();
        void setTrueAndWrong(int trueAnswers, int wrongAnswers);
        void setColorNext();
        void clearColorNext();
        void setVisibly();
        void clearVisibly();
        void setClickable();
        void clearClickable();

    }

    interface Model {
        List<QuestionData> getSelectCategory();
    }

    interface Presenter {
        void selectAnswer(int pos);
        void clickNextButton();
        void clickSkipButton();
        void finishSkipButton();
        void getQuestionById();
        void loadQuestions();
    }

}

