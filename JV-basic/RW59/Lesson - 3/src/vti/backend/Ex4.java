package vti.backend;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Ex4 ex4 = new Ex4();
//        ex4.ques1();
//        ex4.ques2();
    }

    public void ques1(){
        Scanner q1 = new Scanner(System.in);
        System.out.print("Hãy nhập vào chuỗi ký tự: ");

        String input = q1.nextLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.println("ký tự thứ: " + (i+1) + "là: " + input.charAt(i));
        }
    }

    public void ques2(){
        Scanner q2 = new Scanner(System.in);
        System.out.print("Hãy nhập vào chuỗi ký tự s1: ");
        String s1 = q2.nextLine();
        System.out.print("Hãy nhập vào chuỗi ký tự s2: ");
        String s2 = q2.nextLine();

        String s3 = s1.concat(s2);
        System.out.println(s3);
        }

//    public void ques3(){
//        Scanner q3 = new Scanner(System.in);
//        System.out.print("Hãy nhập vào tên: ");
//
//        String viet_hoa = String.valueOf(q3.)
//        }
    }
