package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int menu;
        Scanner scanner = new Scanner(System.in);
        Funtion2 funtion2 = new Funtion2();
        while (true) {
            System.out.println("------------------------- MENU -----------------------");
            System.out.println(" Mời chọn chức năng");
            System.out.println("1. Danh sách Car");
            System.out.println("2. Thêm mới Car");
            System.out.println("3. Tìm kiếm Car theo id");
            System.out.println("4. Update Car");
            System.out.println("5. Xoá Car theo Id");
            System.out.println("6. Danh sách ô tô được sản xuất trong năm");
            System.out.println("7. Thoát");

            menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    funtion2.getAllCar();
                    break;
                case 2:
                    funtion2.addNewCar();
                    break;
                case 3:
                    funtion2.findbycarID();
                    break;
                case 4:
                    funtion2.updateCar();
                    break;
                case 5:
                    funtion2.delbyCarID();
                    break;
                case 6:
                    funtion2.demoStoreprocedure();
                    break;
                case 7:
                    return;
            }
        }
    }
}



