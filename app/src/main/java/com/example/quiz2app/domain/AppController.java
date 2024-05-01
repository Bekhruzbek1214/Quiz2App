package com.example.quiz2app.domain;

import android.util.Log;

import com.example.quiz2app.R;
import com.example.quiz2app.data.model.CategoryEnum;
import com.example.quiz2app.data.model.QuestionData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppController {
    private static AppController controller;
    private CategoryEnum categoryEnum;
    private final List<QuestionData> ls = new ArrayList<>();;

    private AppController(){}

    public static AppController getInstance() {
        if (controller == null)
            controller = new AppController();
        return controller;
    }

    public void setSelectedCategory(CategoryEnum category) {
        this.categoryEnum = category;
        loadQuestions();
    }

    private void loadQuestions(){
        ls.clear();
        if(categoryEnum.equals(CategoryEnum.SCIENTIST)){
            ls.add(new QuestionData("What is the basic unit of measurement for electric current?", "Ampere", "Ohm", "Volt", "Watt", "Ampere",R.drawable.electr));
            ls.add(new QuestionData("What is the chemical symbol for water?", "H2O", "CO2", "O2", "CH4", "H2O",R.drawable.water));
            ls.add(new QuestionData("Which organelle is known as the \"powerhouse\" of the cell?", "Mitochondria", "Nucleus", "Ribosome", "Endoplasmic reticulum", "Mitochondria", R.drawable.power_house));
            ls.add(new QuestionData("What is the closest star to Earth?", "Proxima Centauri", "Sirius", "Alpha Centauri", "Betelgeuse", "Proxima Centauri",R.drawable.star));
            ls.add(new QuestionData("What is the hardest natural substance on Earth?", "Diamond", "Quartz", "Obsidian", "Gold", "Diamond" ,R.drawable.hardestsubstance));
            ls.add(new QuestionData("What is the value of pi (π) to two decimal places?", "3.14", "2.71", "1.61", "4.20", "3.14",R.drawable.pi));
            ls.add(new QuestionData("What does the acronym \"CPU\" stand for in computing?", "Central Processing Unit (CPU)", "Random Access Memory (RAM)", "Graphics Processing Unit (GPU)", "Hard Disk Drive (HDD)", "Central Processing Unit (CPU)", R.drawable.cpu));
            ls.add(new QuestionData("Which vitamin is synthesized in the skin when exposed to sunlight?", "Vitamin D", "Vitamin A", "Vitamin C", "Vitamin K", "Vitamin D", R.drawable.vitamin));
            ls.add(new QuestionData("What is the primary greenhouse gas responsible for Earth's warming?", "Carbon dioxide (CO2)", "Methane (CH4)", "Nitrous oxide (N2O)", "Ozone (O3)", "Carbon dioxide (CO2)", R.drawable.earth));
            ls.add(new QuestionData("What is the law of conservation of energy?", "Law of Gravity", "Law of Motion", "Law of Conservation of Energy", "Law of Thermodynamics", "Law of Conservation of Energy",R.drawable.conversation1));
        } else if (categoryEnum.equals(CategoryEnum.GEOGRAPHY)) {
            ls.add(new QuestionData("Which continent is the Amazon Rainforest primarily located in?", "South America", "North America", "Europe", "Asia", "South America", R.drawable.south_america));
            ls.add(new QuestionData("What is the longest river in the world?", "Nile", "Amazon", "Yangtze", "Mississippi", "Nile", R.drawable.nile));
            ls.add(new QuestionData("Which is the world's highest mountain?", "Mount Everest", "K2", "Kangchenjunga", "Lhotse", "Mount Everest", R.drawable.mountain));
            ls.add(new QuestionData("Which continent is known as the 'Land Down Under'?", "Australia", "North America", "Europe", "Asia", "Australia", R.drawable.australia));
            ls.add(new QuestionData("Which is the largest ocean on Earth?", "Pacific Ocean", "Arctic Ocean", "Atlantic Ocean", "Indian Ocean", "Pacific Ocean", R.drawable.ocean));
            ls.add(new QuestionData("Which South American country is known for the Andes Mountains?", "Peru", "Brazil", "Argentina", "Colombia", "Peru", R.drawable.peru));
            ls.add(new QuestionData("Which Asian city is the most populous in the world?", "Tokyo", "Beijing", "Seoul", "Bangkok", "Tokyo", R.drawable.tokyo));
            ls.add(new QuestionData("In which country is the ancient city of Troy located?", "Turkey", "Egypt", "Greece", "Italy", "Turkey", R.drawable.troy));
            ls.add(new QuestionData("Which country is the largest by land area?", "Canada", "China", "Russia", "United States", "Russia", R.drawable.australia));
            ls.add(new QuestionData("Which U.S. city is known as the 'Windy City'?", "Chicago", "New York", "Los Angeles", "Houston", "Chicago", R.drawable.windy));
        } else if (categoryEnum.equals(CategoryEnum.HISTORY)) {
            ls.add(new QuestionData("Where did the Olympic Games originate?", "Ancient Greece", "Ancient Rome", "Ancient Egypt", "Mesopotamia", "Ancient Greece", R.drawable.olympic));
            ls.add(new QuestionData("Which revolution led to the rise of Napoleon Bonaparte?", "French Revolution", "American Revolution", "Russian Revolution", "Industrial Revolution", "French Revolution", R.drawable.napolion));
            ls.add(new QuestionData("Who was a prominent leader in the American Civil Rights Movement?", "Martin Luther King Jr.", "Malcolm X", "Rosa Parks", "Nelson Mandela", "Martin Luther King Jr.", R.drawable.leader));
            ls.add(new QuestionData("In which war did the Battle of Stalingrad take place?", "World War II", "World War I", "Cold War", "Vietnam War", "World War II", R.drawable.stalin));
            ls.add(new QuestionData("Who was the first European explorer to reach India by sea?", "Vasco da Gama", "Christopher Columbus", "Marco Polo", "Ferdinand Magellan", "Vasco da Gama", R.drawable.vascodagamma));
            ls.add(new QuestionData("Which ancient civilization built the Great Wall of China?", "Ancient China", "Ancient Rome", "Ancient Greece", "Ancient Egypt", "Ancient China", R.drawable.china));
            ls.add(new QuestionData("Which document is considered a foundation for constitutional government?", "Magna Carta", "Declaration of Independence", "Emancipation Proclamation", "Bill of Rights", "Magna Carta", R.drawable.constituion));
            ls.add(new QuestionData("Which period saw a renewed interest in art, science, and learning in Europe?", "Renaissance", "Enlightenment", "Industrial Revolution", "Scientific Revolution", "Renaissance", R.drawable.renesans));
            ls.add(new QuestionData("What was built to separate East and West Berlin during the Cold War?", "Berlin Wall", "Great Wall of China", "Hadrian's Wall", "Antonine Wall", "Berlin Wall", R.drawable.berlin));
            ls.add(new QuestionData("Who was a key figure in the Indian independence movement against British rule?", "Mahatma Gandhi", "Jawaharlal Nehru", "Subhas Chandra Bose", "Sardar Patel", "Mahatma Gandhi", R.drawable.india));
        } else if (categoryEnum.equals(CategoryEnum.COMPUTER_SCIENCE)) {
            ls.add(new QuestionData("What does the acronym 'CPU' stand for in computing?", "Central Processing Unit", "Random Access Memory", "Graphics Processing Unit", "Hard Disk Drive", "Central Processing Unit", R.drawable.cpu2));
            ls.add(new QuestionData("Which programming language is known for its readability and simplicity?", "Python", "Java", "C++", "Ruby", "Python", R.drawable.language));
            ls.add(new QuestionData("Which protocol is used for transferring files over the internet?", "FTP", "TCP/IP", "HTTP", "SMTP", "FTP", R.drawable.ftp));
            ls.add(new QuestionData("In programming, what is a series of instructions that can be reused called?", "Function", "Algorithm", "Variable", "Loop", "Function", R.drawable.reuse));
            ls.add(new QuestionData("Which field of study focuses on creating intelligent machines?", "Artificial Intelligence", "Machine Learning", "Data Science", "Robotics", "Artificial Intelligence", R.drawable.ai));
            ls.add(new QuestionData("What type of software allows the source code to be freely available for the public to view, modify, and distribute?", "Open Source", "Closed Source", "Freeware", "Shareware", "Open Source", R.drawable.source));
            ls.add(new QuestionData("Which language is used for creating the structure of a webpage?", "HTML", "CSS", "JavaScript", "Python", "HTML", R.drawable.html));
            ls.add(new QuestionData("How much RAM (Random Access Memory) is equal to 1024 megabytes?", "1 GB", "512 MB", "2 GB", "4 GB", "1 GB", R.drawable.ram));
            ls.add(new QuestionData("Which program translates high-level programming code into machine code?", "Compiler", "Interpreter", "Assembler", "Linker", "Compiler", R.drawable.compiler));
            ls.add(new QuestionData("What is the basic unit of digital information?", "Bit", "Nibble", "Byte", "Word", "Bit", R.drawable.img));
        }
    }

    public List<QuestionData> getQuestionByCategory() {
        Log.d("TTT", "asdfghjkl");
        Collections.shuffle(ls);
        return ls.subList(0, 10);
    }

}

