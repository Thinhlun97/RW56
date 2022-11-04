package com.vti.backend.Ex5_Q4;

import java.time.LocalDate;

public class Bao extends QLTL {
    private int maTaiLieu;
    private String tenNXB;
    private String soBPH;
    private LocalDate ngayPH;

    public Bao(int maTaiLieu, String tenNXB, String soBPH) {
        super(maTaiLieu, tenNXB, soBPH);
    }

    public Bao(int maTaiLieu, String tenNXB, String soBPH, LocalDate ngayPH) {
        super(maTaiLieu, tenNXB, soBPH);
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBPH = soBPH;
        this.ngayPH = ngayPH;
    }

    @Override
    public String toString() {
        return "Bao{" +
                "maTaiLieu=" + maTaiLieu +
                ", tenNXB='" + tenNXB + '\'' +
                ", soBPH='" + soBPH + '\'' +
                ", ngayPH=" + ngayPH +
                '}';
    }
}
