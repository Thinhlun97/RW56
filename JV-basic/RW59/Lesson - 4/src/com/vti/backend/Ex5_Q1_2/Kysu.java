package com.vti.backend.Ex5_Q1_2;

public class Kysu extends CanBo {
    private String nghanhDaoTao;

    public Kysu() {
    }

    public Kysu(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, String nghanhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nghanhDaoTao = nghanhDaoTao;
    }

    @Override
    public String toString() {
        return "Kysu{" +
                "hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi + '\'' +
                ", nghanhDaoTao='" + nghanhDaoTao + '\'' +
                '}';
    }
}

