package com.vti.backend.Ex5_Q4;

public class Sach extends QLTL{
    private int maTaiLieu;
    private String tenNXB;
    private String soBPH;
    private String tenTG;
    private int soTrang;


    public Sach(int maTaiLieu, String tenNXB, String soBPH,  String tenTG, int soTrang) {
        super(maTaiLieu, tenNXB, soBPH);
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBPH = soBPH;
        this.tenTG = tenTG;
        this.soTrang = soTrang;
    }

    public Sach(int maTaiLieu, String tenNXB, String soBPH) {
        super(maTaiLieu, tenNXB, soBPH);


    }


    @Override
    public String toString() {
        return "Sach{" +
                "maTaiLieu=" + maTaiLieu +
                ", tenNXB='" + tenNXB + '\'' +
                ", soBPH='" + soBPH + '\'' +
                ", tenTG='" + tenTG + '\'' +
                ", soTrang=" + soTrang +
                '}';
    }
}
