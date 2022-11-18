package com.vti.frontend;


import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        int menu;
        Scanner scanner = new Scanner(System.in);
        Funtion funtion = new Funtion();
        while (true) {
            System.out.println("------------------------- MENU -----------------------");
            System.out.println(" Mời chọn chức năng");
            System.out.println("1. Danh sách Account");
            System.out.println("2. Tìm kiếm Account theo name");
            System.out.println("3. Tìm kiếm Account theo id");
            System.out.println("4. Update account");
            System.out.println("5. Xoá Account theo Id");
            System.out.println("6. Thoát");

            menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    funtion.getAllAccount();
                    break;
                case 2:
                    funtion.getByname();
                    break;
                case 3:
                    funtion.getById();
                    break;
                case 4:
//                    deletaCanbo();
                    break;
                case 5:
                    // method here
                    break;
                case 6:
                    return;
            }
        }
    }

}