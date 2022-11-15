package com.vti.backend.Ex5_Q3;

public class HighSchoolStudent extends Student{
    private int id;
    String clazz;
    String desiredUniversity;

    public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
        super(name, id);
        this.id = id;
        this.clazz = clazz;
        this.desiredUniversity = desiredUniversity;
    }

    @Override
    public String toString() {
        return "HighSchoolStudent{" +
                "id=" + id + '\'' +
                ", name=" + super.getName() + '\'' +
                ", clazz='" + clazz + '\'' +
                ", desiredUniversity='" + desiredUniversity + '\'' +
                "} " + super.toString();
    }
}
