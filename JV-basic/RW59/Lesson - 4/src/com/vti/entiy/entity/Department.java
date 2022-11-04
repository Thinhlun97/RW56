package com.vti.entiy.entity;

public class Department {
    public int departmentId;
    public String departmentname;

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentname='" + departmentname + '\'' +
                '}';
    }
}
