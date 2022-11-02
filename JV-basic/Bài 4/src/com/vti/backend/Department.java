package com.vti.backend;

public class Department {
    public int id;
    public String name;

    public Department(){
        id = 0;
        name = "default - name";
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void showInfo(){
        System.out.println("thông tin của phòng ban này là: ");
        System.out.println("id :" + id);
        System.out.println("name :" + name);
    }
}
