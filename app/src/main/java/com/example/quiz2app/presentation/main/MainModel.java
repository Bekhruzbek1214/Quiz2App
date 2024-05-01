package com.example.quiz2app.presentation.main;

import com.example.quiz2app.data.model.QuestionData;
import com.example.quiz2app.domain.AppController;

import java.util.List;

public class MainModel implements MainContract.Model{
    private AppController controller = AppController.getInstance();
    private List<QuestionData> ls;
    @Override
    public List<QuestionData> getSelectCategory() {
        ls = controller.getQuestionByCategory();
        return ls;
    }

}
