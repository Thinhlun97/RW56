package com.vti.backend.Ex1.Q2;

public enum KhoiThi {
    A("Toán, Lý, Hoá", "A"), B("Toán, Hoá, Sinh","B"), C("Văn, Sử, Địa", "C");

    public final String monHoc;
    public final String kyHieu;


    KhoiThi(String monHoc, String kyHieu){
        this.monHoc = monHoc;
        this.kyHieu = kyHieu;
    }

    public String getMonHoc() {
        return monHoc;
    }
}
