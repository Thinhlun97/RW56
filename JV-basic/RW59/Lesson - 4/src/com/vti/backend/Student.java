package com.vti.backend;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private float mark;

    public Student(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
        this.mark = 0;
    }

    public void setMark(float mark){
        this.mark = mark;
    }

    public void congdiem(float diemcong){
        this.mark = mark + diemcong;
    }

    public void inthongtin(){
        System.out.println("tên là: " + this.name);
        if (this.mark < 4){
            System.out.println("học lực yếu");
        }else if (this.mark>4 && this.mark<6){
            System.out.println("học lực trung bình");
        }else if(this.mark>6 && this.mark<8){
            System.out.println("học lực khá");
        }else{
            System.out.println("học lực giỏi");
        }
        System.out.println(this.mark);
    }
}
