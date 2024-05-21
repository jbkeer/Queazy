package com.quiz.quizapp.model;

import java.util.List;

public class Question {

    private String question;
    private List<String> options;
    private String answer;

    public Question() {
        // Default constructor
    }

    // Getters and setters
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

}
