package vti.backend;

import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Ex1 ex3 = new Ex1();
//        ex3.ques1();
//        ex3.ques2();
        ex3.ques3();
    }

    public void ques1(){
        float luong_1 = 5240.5f;
        float luong_2 = 10970.055f;

        int tronluong_1 = (int) luong_1;
        System.out.println(" làm tròn lương 1 là: " + tronluong_1 );

        int tronluong_2 = (int) luong_2;
        System.out.println(" làm tròn lương 2 là: " + tronluong_2 );
    }

    public void ques2(){
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
    }

    public void ques3(){
        Random random = new Random();

        int x = random.nextInt(99999);
        System.out.println("số ngẫu nhiên x là:" + x);
        String y = String.valueOf(x);
        int lengthofString = y.length();

        for (int i = 0; i < 5-lengthofString; i++){
            y = "0"+y;
        }
        System.out.println(y.charAt(3));
        System.out.println(y.charAt(4));

    }

    public void ques4(){

    }

}
