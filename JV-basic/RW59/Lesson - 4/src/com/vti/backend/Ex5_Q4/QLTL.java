package com.vti.backend.Ex5_Q4;

public class QLTL {
    int maTaiLieu;
    String tenNXB;
    String soBPH;

    @Override
    public String toString() {
        return "QLTL{" +
                "maTaiLieu=" + maTaiLieu +
                ", tenNXB='" + tenNXB + '\'' +
                ", soBPH='" + soBPH + '\'' +
                '}';
    }

    public QLTL(int maTaiLieu, String tenNXB, String soBPH) {
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBPH = soBPH;


    }
}
