package com.example.quiz2app.presentation.category;

import com.example.quiz2app.data.model.CategoryEnum;

public interface CategoryContract {

    interface View {

    }

    interface  Model{
        void setSelectCategory(CategoryEnum category);
    }

    interface Presenter{
        void setSelectCategory(CategoryEnum category, int pos);
    }

}
