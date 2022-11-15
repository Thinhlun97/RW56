package com.vti.backend.Ex5_Q4;

public class QLTV {
     int id;
    private String tenNXB;
    private int soBPH;


    public QLTV(int maTaiLieu, String tenNXB, int soBPH) {
        this.id = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBPH = soBPH;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "QLTL{" +
                "maTaiLieu=" + id +
                ", tenNXB='" + tenNXB + '\'' +
                ", soBPH='" + soBPH + '\'' +
                '}';
    }
}
