package com.vti.demo;

import com.vti.entiy.entity.Question;

public class Answer {
    private int id;
    public String content;
    public boolean isCorrect;
    public Question question;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                '}';
    }
}
