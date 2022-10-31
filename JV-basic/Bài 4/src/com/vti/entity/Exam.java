package com.vti.entity;

import java.time.LocalDate;

public class Exam {
    public int examId;
    public String code;
    public String title;
    public CategoryQuestion categoryExam;
    public int duration;
    public Account creator;
    public LocalDate createDate;
    public Question[] questions;


}
