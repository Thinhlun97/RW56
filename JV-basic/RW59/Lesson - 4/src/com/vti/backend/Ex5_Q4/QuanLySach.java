package com.vti.backend.Ex5_Q4;

import java.time.LocalDate;

public class QuanLySach {
    public static void main(String[] args) {
        Sach sach1 = new Sach(1, "NXH1", "1", "TG1", 30);

        System.out.println(sach1);

        TapChi tapChi1 = new TapChi(2,"NXH2","2",10,8);

        System.out.println(tapChi1);

        Bao bao1 = new Bao(3, "NXH3","3", LocalDate.parse("2020-09-01"));
        System.out.println(bao1);
    }
}
