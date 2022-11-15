package com.vti.backend.Ex5_Q4;

import java.time.LocalDate;

public class Bao extends QLTV {
    private LocalDate ngayPH;

    public Bao(int maTaiLieu, String tenNXB, int soBPH, LocalDate ngayPH) {
        super(maTaiLieu, tenNXB, soBPH);
        this.ngayPH = ngayPH;
    }

    @Override
    public String toString() {
        return "Bao{" +
                "ngayPH=" + ngayPH +
                "} " + super.toString();
    }
}
