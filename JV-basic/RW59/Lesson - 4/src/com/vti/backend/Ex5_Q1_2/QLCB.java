package com.vti.backend.Ex5_Q1_2;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<CanBo> canBos = new ArrayList<>();

    public static void main(String[] args) {

        int menu;
        while (true) {
            System.out.println(" Mời chọn chức năng");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiện thị thông tin về danh sách các cán bộ");
            System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó");
            System.out.println("5. Thoát");
            menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    addCanbo();
                    System.out.println("Chức năng thêm mới cán bộ");
                    break;
                case 2:
                    sreachCanbo();
                    System.out.println("Chức năng tìm kiếm");
                    break;
                case 3:
                    showAllCanbo();
                    System.out.println("Chức năng hiển thị danh sách cán bộ");
                    break;
                case 4:
                    deletaCanbo();
                    System.out.println("Chức năng xóa cán bộ");
                    break;
                case 5:
                    exit();
                    return;

            }
        }

    }

    private static void addCanbo() {
        System.out.println("Mời nhập vào họ và tên cán bộ: ");
        String hoTen = scanner.nextLine();
        System.out.println("Mời nhập vào tuổi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn chọn giới tính: ");
        GioiTinh gioiTinh;
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        int chongioiTinh = Integer.parseInt(scanner.nextLine());
        if (chongioiTinh == 1) {
            gioiTinh = GioiTinh.NAM;
        } else if (chongioiTinh == 2) {
            gioiTinh = GioiTinh.NU;
        } else {
            gioiTinh = GioiTinh.KHAC;
        }

        System.out.println("Mời nhập địa chỉ: ");
        String diaChi = scanner.nextLine();

        CanBo canbo = new CanBo(hoTen, tuoi, gioiTinh, diaChi);

        canBos.add(canbo);
        System.out.println("Đã thêm mới cán bộ thành công!!!");
    }

    private static void sreachCanbo() {
        System.out.println("Mời nhập họ tên cán bộ cần tìm: ");
        String hoTen = scanner.nextLine();
        for (CanBo canBo : canBos) {
            if (canBo.hoTen.equals(hoTen)) {
                System.out.println(canBo);
            }
        }

    }


    private static void showAllCanbo() {
        System.out.println("-------Danh sách cán bộ: ");
        System.out.println(canBos);
    }


    private static void deletaCanbo() {
        System.out.println("Mời nhập họ tên cán bộ cần xóa: ");
        String hoTen = scanner.nextLine();

        for (int i = 0; i < canBos.size(); i++) {
            if (canBos.get(i).hoTen.equals(hoTen)) {
                canBos.remove(canBos.get(i));
                System.out.println("Đã xóa thành công");
            }
        }
    }


    private static void exit() {
    }

}