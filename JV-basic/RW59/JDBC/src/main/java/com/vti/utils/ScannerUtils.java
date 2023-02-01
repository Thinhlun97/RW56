package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
    static Scanner scanner = new Scanner(System.in);

    public static int inputIntPositive() {
        while (true) {
            try {

                int intPositive = Integer.parseInt(scanner.nextLine());
                if (intPositive >= 0) {
                    return intPositive;
                } else {
                    System.err.println("Số nhập vào phải là số dương. Mời nhập lại:");
                }
            } catch (Exception e) {
                System.err.println("Nhập vào phải là số. Mời nhập lại: ");
            }
        }
    }

    public static String inputString() {
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) {
                return string;
            } else {
                System.err.println("Nhập lại: ");
            }
        }
    }

    public static String inputEmail() {
        while (true) {
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.err.println("Nhập lại: ");
                continue;
            }  else if (!string.endsWith("@vti.com.vn")){
                System.err.println("Nhập lại: ");
                continue;
            } else {
                return string;
            }
        }
    }

    public static String inputPasswords() {
        while (true) {
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.err.println("Sai định dạng, Nhập lại: ");
            }  else if (string.length() < 6 || string.length() >12){
                System.err.println("Nhập lại: ");
            } else {
                return string;
            }
        }
    }
}
