package com.vti.backend.Ex5_Q4;

import java.time.LocalDate;

public class TapChi extends QLTV {
    private int soPH;
    private final LocalDate thangPH;

    public TapChi(int maTaiLieu, String tenNXB, int soBPH, int soPH, LocalDate thangPH) {
        super(maTaiLieu, tenNXB, soBPH);
        this.soPH = soPH;
        this.thangPH = thangPH;
    }

    @Override
    public String toString() {
        return "TapChi{" +
                "soPH=" + soPH +
                ", thangPH=" + thangPH +
                "} " + super.toString();
    }
}
