package com.vti.backend.Ex1.Q1;

import java.util.Scanner;

public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    public News(String title, String publishDate, String author, String content) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public void disPlay() {
        System.out.println("Title: " + this.title);
        System.out.println("PublishDate: " + this.publishDate);
        System.out.println("Author: " + this.author);
        System.out.println("Content: " + this.content);
        System.out.println("AverageRate: " + this.averageRate);

    }

    @Override
    public float calculate() {
        Scanner sc = new Scanner(System.in);
        float[] ratting = new float[3];
        System.out.println("Mời đánh giá bài viêt");
        ratting[0] = sc.nextFloat();
        ratting[1] = sc.nextFloat();
        ratting[2] = sc.nextFloat();
        this.averageRate = (ratting[0] + ratting[1] + ratting[2]) / 3;
        return this.averageRate;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", averageRate=" + averageRate +
                '}';
    }
}
