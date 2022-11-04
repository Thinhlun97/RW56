package com.vti.backend.Ex5_Q4;

import java.util.Date;

public class TapChi extends QLTL{
    private int maTaiLieu;
    private String tenNXB;
    private String soBPH;
    private int soPH;
    private int thangPH;

    public TapChi(int maTaiLieu, String tenNXB, String soBPH) {
        super(maTaiLieu, tenNXB, soBPH);
    }

    public TapChi(int maTaiLieu, String tenNXB, String soBPH, int soPH, int thangPH) {
        super(maTaiLieu, tenNXB, soBPH);
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBPH = soBPH;
        this.soPH = soPH;
        this.thangPH = thangPH;
    }

    @Override
    public String toString() {
        return "TapChi{" +
                "maTaiLieu=" + maTaiLieu +
                ", tenNXB='" + tenNXB + '\'' +
                ", soBPH='" + soBPH + '\'' +
                ", soPH=" + soPH +
                ", thangPH=" + thangPH +
                '}';
    }
}
