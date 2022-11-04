package com.vti.frontend;

import com.vti.backend.Student;

public class demo {
    public static void main(String[] args) {
        Student student1 = new Student("thinh", "hanoi");
        student1.setMark(6);
        student1.congdiem(2.5f);
        student1.inthongtin();
    }
}
