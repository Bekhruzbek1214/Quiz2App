package com.example.quiz2app.data.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {
    private final String question;
    private final List<String> varians;
    private final String answer;
    private Integer ans = -1;
    private int image;

    public QuestionData(
            String question,
            String variant1,
            String variant2,
            String variant3,
            String variant4,
            String answer,
            int image) {

        this.question = question;
        this.varians = new ArrayList<>(4);
        this.answer = answer;
        this.image = image;

        varians.add(variant1);
        varians.add(variant2);
        varians.add(variant3);
        varians.add(variant4);

    }

    public String getQuestion() {
        return question;
    }

    public List<String> getVarians() {
        return varians;
    }
    public int getImage(){
        return image;
    }

    public void setAns(int i) {
        ans = i;
    }

    public int getAns() {
        return ans;
    }
    public String getAnswer() {
        return answer;
    }
}