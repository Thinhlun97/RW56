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
}
