package com.example.quiz2app.presentation.category;

import com.example.quiz2app.data.model.CategoryEnum;

public class CategoryPresenter implements  CategoryContract.Presenter {
    private CategoryContract.View view;
    private CategoryContract.Model model;

    CategoryPresenter(CategoryContract.View view) {
        this.view = view;
        model = new CategoryModel();
    }

    @Override
    public void setSelectCategory(CategoryEnum category, int pos) {
        model.setSelectCategory(category);

    }
}
