package com.vti.entity;

import java.util.Scanner;

public class ScannerUtills {
    static Scanner sc = new Scanner(System.in);

    public static String inputuserName(){
        System.out.println("Mời bạn nhập vào username");
        String kq = "";
        while (true){
            kq = sc.nextLine();
            if (kq.length() < 1 || kq.length() > 6 ){
                System.out.println("Giá trị không hợp lệ, mời nhập lại: ");
                continue;
            } else {
                break;
            }
        }
        return kq;

    }
}
