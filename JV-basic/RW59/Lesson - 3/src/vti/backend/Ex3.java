package vti.backend;

public class Ex3 {
    public static void main(String[] args) {
        Ex3 ex3 = new Ex3();
//        ex3.ques1();
//        ex3.ques2();
        ex3.ques3();
    }

    public void ques1() {
        Integer luong1 = Integer.valueOf(5000);

        float x = luong1.floatValue();
        float y = Float.valueOf(luong1);
        float z = (float) luong1;

        System.out.printf("%.02f", x);
    }


    public void ques2() {
        String x = "1234567";

        int y = Integer.valueOf(x);

        System.out.println(y);
    }

    public void ques3() {
        Integer x = 1234567;

        int y = Integer.valueOf(x);

        System.out.println(y);
    }
}
