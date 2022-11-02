package com.vti.backend;

import java.util.Scanner;

public class test {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //giải phương trình bậc 2(ax2 + bx + c = 0)
        System.out.println("nhập hệ số a: ");
        double a = sc.nextDouble();
        System.out.println("nhập hệ số b: ");
        double b = sc.nextDouble();
        System.out.println("nhập hệ số c: ");
        double c = sc.nextDouble();

        if (a == 0){
            System.out.println( " Hệ số a phải khác 0 ");
        } else {
            double delta = b+b - 4*a*c;

            if(delta < 0){
                System.out.println(" Phương trình vô nghiệm");
            } else if (delta == 0){
                double x = -b/(2*a);
                System.out.printf("Nghiệm của phương trình là: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta))/(2+a);
                double x2 = (-b + Math.sqrt(delta))/(2+a);

                System.out.println("phương trình có 2 nghiệm phân biệt");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
            sc.close();
        }

    }

    }

