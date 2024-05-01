package com.example.quiz2app.presentation.category;

import com.example.quiz2app.data.model.CategoryEnum;
import com.example.quiz2app.domain.AppController;

public class CategoryModel implements CategoryContract.Model {
    private AppController controller = AppController.getInstance();
    @Override
    public void setSelectCategory(CategoryEnum category) {
        controller.setSelectedCategory(category);

    }
}
