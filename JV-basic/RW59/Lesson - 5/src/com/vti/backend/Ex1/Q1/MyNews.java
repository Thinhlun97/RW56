package com.vti.backend.Ex1.Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
    static ArrayList<News> list1 = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        while (true) {
            System.out.println(" Mời chọn chức năng");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");

            menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    insertnews();
                    System.out.println("Chức năng thêm mới tin tức");
                    break;
                case 2:
                    viewlistnews();
                    System.out.println("Chức năng xem tin tức");
                    break;
                case 3:
                    averagerate();
                    System.out.println("Chức năng đánh giá tin tức");
                    break;
                case 4:
                    exit();
                    return;
            }
        }
    }

    private static void averagerate() {
        float calculate = scanner.nextFloat();
        System.out.println(calculate);


    }

    private static void viewlistnews() {
        System.out.println(list1);
    }

    private static void insertnews() {
        System.out.println("mời bạn nhập Title: ");
        String title = scanner.nextLine();
        System.out.println("mời bạn nhập PublishDate: ");
        String publishDate = scanner.nextLine();
        System.out.println("mời bạn nhập author: ");
        String author = scanner.nextLine();
        System.out.println("mời bạn nhập content: ");
        String content = scanner.nextLine();
        News news1 = new News(title,publishDate,author,content);
        news1.calculate();
        list1.add(news1);
    }

    private static void exit() {
    }
}