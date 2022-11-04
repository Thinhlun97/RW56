package vti.backend;

import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
//        ex1.ques1();
//        ex1.ques2();
//        ex1.ques3();
        ex1.ques4();
    }

    public void ques1(){
        float luong_1 = 5240.5f;
        float luong_2 = 10970.055f;

        int tronluong_1 = (int) luong_1;
        System.out.println(" làm tròn lương 1 là: " + tronluong_1 );

        int tronluong_2 = (int) luong_2;
        System.out.println(" làm tròn lương 2 là: " + tronluong_2 );
    }

    public int ques2(){
        Random random = new Random();

        int x = random.nextInt(99999);
        System.out.println("số ngẫu nhiên x là:" + x);
        //  if else
//        if(x > 9999){
//            System.out.println(x);
//        }else if(x > 999){
//            System.out.println("0"+x);
//        }else if(x > 99){
//            System.out.println("00"+x);
//        }else if(x > 9){
//            System.out.println("000"+x);
//        }else {
//            System.out.println("0000"+x);
//        }

        String y = String.valueOf(x);
        int lengthofString = y.length();

        for (int i = 0; i < 5-lengthofString; i++){
            y = "0"+y;
        }
        System.out.println(y);
        return x;
    }

    public void ques3(){
        //cách 1
        int random_x = ques2();

        String y = String.valueOf(random_x);
        String kq = y.substring(y.length() - 2);
        System.out.println(kq);

        //cách 2
        int c2 = random_x % 100;
        System.out.println(c2);

    }

    public void ques4(){
        Scanner q4 = new Scanner(System.in);
        System.out.print("Hãy nhập vào số a: ");
        int a = q4.nextInt();
        System.out.print("Hãy nhập vào số b: ");
        int b = q4.nextInt();

        int c = a/b;
        System.out.println("Kết quả là : " + c);

    }

}
