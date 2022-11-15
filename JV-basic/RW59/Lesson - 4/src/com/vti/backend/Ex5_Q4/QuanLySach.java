package com.vti.backend.Ex5_Q4;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    public static int id = 0;
    static Scanner sc = new Scanner(System.in);

    static ArrayList<QLTV> qltvs = new ArrayList<>();

    public static void main(String[] args) {

        int menu;

        while (true) {
            System.out.println(" Mời chọn chức năng");
            System.out.println("1. Thêm mới tài liệu: Sách, tạp chí, báo.");
            System.out.println("2. Xóa tài liệu theo mã tài liệu");
            System.out.println("3. Hiện thị thông tin về tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.");
            System.out.println("5. Thoát");
            menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:
                    addQLTV();
                    System.out.println("Chức năng thêm mới tài liệu");
                    break;
                case 2:
                    delQLTV();
                    System.out.println("Chức năng Xóa tài liệu");
                    break;
                case 3:
                    showQLTV();
                    System.out.println("Chức năng Hiện thị thông tin về tài liệu");
                    break;
                case 4:
                    searchQLTV();
                    System.out.println("Tìm kiếm tài liệu");
                    break;
                case 5:
                    exit();
                    return;

            }

        }
    }

    private static void delQLTV() {
    }

    private static void exit() {
    }

    private static void addQLTV(){
        System.out.println("Lựa chọn loại tài liệu muốn thêm mới");
        System.out.println("1. Thêm sách");
        System.out.println("2. Thêm tạp chí");
        System.out.println("3. Thêm báo");


        int chonloaitl = Integer.parseInt(sc.nextLine());
        switch (chonloaitl){
            case 1:
                System.out.println("Nhập vào tên nhà xuât bản: ");
                String tenNXB = sc.nextLine();
                System.out.println("Nhập vào số bản phát hành: ");
                int soBPH = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào tên tác giả: ");
                String tenTG = sc.nextLine();
                System.out.println("Nhập vào số trang: ");
                int soTrang = Integer.parseInt(sc.nextLine());
                id++;
                QLTV sach = new Sach(id,tenNXB,soBPH,tenTG,soTrang);
                qltvs.add(sach);
                break;
            case 2:
                System.out.println("Nhập vào tên nhà xuât bản: ");
                String tenNXBtc = sc.nextLine();
                System.out.println("Nhập vào số bản phát hành: ");
                int soBPHtc = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào số phát hành: ");
                int soPH = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào ngày phát hành: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào tháng phát hành: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào năm phát hành: ");
                int year = Integer.parseInt(sc.nextLine());
                LocalDate thangPH = LocalDate.of(year,month,day);
                id++;
                QLTV tapChi = new TapChi(id,tenNXBtc,soBPHtc,soPH,thangPH);
                qltvs.add(tapChi);
                break;
            case 3:
                System.out.println("Nhập vào tên nhà xuât bản: ");
                String tenNXBb = sc.nextLine();
                System.out.println("Nhập vào số bản phát hành: ");
                int soBPHb = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào ngày phát hành: ");
                int day1 = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào tháng phát hành: ");
                int month1 = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập vào năm phát hành: ");
                int year1 = Integer.parseInt(sc.nextLine());
                LocalDate ngayPH = LocalDate.of(year1,month1,day1);
                id++;
                QLTV bao = new Bao(id,tenNXBb,soBPHb,ngayPH);
                qltvs.add(bao);
                break;
            default:
                break;
        }
    }



    private static void showQLTV(){
        System.out.println(qltvs);
    }

    private static void searchQLTV() {
        System.out.println("Lựa chọn loại tài liệu muốn thêm mới");
        System.out.println("1. Thêm sách");
        System.out.println("2. Thêm tạp chí");
        System.out.println("3. Thêm báo");

        int chonloaitl1 = sc.nextInt();
        switch (chonloaitl1) {
            case 1:
                for (QLTV qltv : qltvs) {
                    if (qltv instanceof Sach) {
                        System.out.println(qltv);
                    }
                }
                break;
            case 2:
                for (QLTV qltv : qltvs) {
                    if (qltv instanceof TapChi) {
                        System.out.println(qltv);
                    }
                }
                break;
            case 3:
                for (QLTV qltv : qltvs) {
                    if (qltv instanceof Bao) {
                        System.out.println(qltv);
                    }
                }
                break;
            default:
                System.out.println("nhập không đúng !!");
                break;
        }

    }
    private void printQltv(){
        for (QLTV qltv : qltvs) {
            System.out.println(qltv);
        }
    }
}