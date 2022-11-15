package com.vti.backend.Ex5_Q4;

public class Sach extends QLTV {
    private String tenTG;
    private int soTrang;

    public Sach(int maTaiLieu, String tenNXB, int soBPH, String tenTG, int soTrang) {
        super(maTaiLieu, tenNXB, soBPH);
        this.tenTG = tenTG;
        this.soTrang = soTrang;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "tenTG='" + tenTG + '\'' +
                ", soTrang=" + soTrang +
                "} " + super.toString();
    }
}
