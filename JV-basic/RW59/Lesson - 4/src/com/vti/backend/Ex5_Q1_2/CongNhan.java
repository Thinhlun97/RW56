package com.vti.backend.Ex5_Q1_2;

public class CongNhan extends CanBo {
    private int capBac;

    public CongNhan() {
    }

    public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, int capBac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.capBac = capBac;
    }

    public void setCapBac(int capBac) {
        if(capBac > 0 && capBac <= 10){
            this.capBac = capBac;
        }
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi + '\'' +
                ", capBac=" + capBac +
                '}';
    }
}
