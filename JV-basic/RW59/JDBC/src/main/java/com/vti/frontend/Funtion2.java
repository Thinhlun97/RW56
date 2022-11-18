package com.vti.frontend;

import com.vti.backend.controller.CarController;
import com.vti.entity.Car;
import com.vti.entity.Maker;
import com.vti.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

public class Funtion2 {
    CarController controller = new CarController();

    public static void main(String[] args) throws SQLException {
        Funtion2 funtion2 = new Funtion2();
        funtion2.getAllCar();
    }


    public void getAllCar() throws SQLException {
        List<Car> cars = controller.getAllCar();
        printListCar(cars);
    }

    public void addNewCar() throws SQLException {
        System.out.println("Mời bạn chọn hãng sản xuất: ");
        System.out.println("1. HONDA");
        System.out.println("2. TOYOTA");
        System.out.println("3. NISSAN");
        Maker maker;
        int chose = ScannerUtils.inputIntPositive();
        switch (chose) {
            case 1:
                maker = Maker.HONDA;
                break;
            case 2:
                maker = Maker.TOYOTA;
                break;
            default:
                maker = Maker.NISSAN;

        }

        System.out.println("Mời bạn nhập Model: ");
        String model = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập ngày sản xuât: ");
        String year = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập màu của xe: ");
        String color = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập ghi chú: ");
        String note = ScannerUtils.inputString();


        Car car = new Car();
        car.setMaker(maker);
        car.setModel(model);
        car.setDate(year);
        car.setColor(color);
        car.setNote(note);

        controller.addNewCar(car);
    }

    public void findbycarID() throws SQLException {
        System.out.println("Mời bạn nhập vào ID cần tìm kiếm");
        int carID = ScannerUtils.inputIntPositive();
        Car car = controller.findByID(carID);
        if (car == null) {
            System.err.println("Car không tồn tại");
        } else {
            String leftAlignFormat = "| %-3s| %-15s | %-15s | %-20s | %-15s | %-15s |%n";
            System.out.format("+----+-----------------+-----------------+-----------------+-----------------+-----------------%n");
            System.out.format("| id |       Maker     |       Model     |         Date         |       Color     |     Note       |%n");
            System.out.format("+----+-----------------+-----------------+-----------------+-----------------+-----------------%n");
            System.out.format(leftAlignFormat, car.getCarID(), car.getMaker(), car.getModel(), car.getDate(), car.getColor(), car.getNote());
            System.out.format("+----+-----------------+-----------------+-----------------+-----------------+-----------------%n");
        }
    }

    public void delbyCarID() throws SQLException {
        System.out.println("Mời bạn nhập carID muốn xóa!");
        int carID = ScannerUtils.inputIntPositive();
        controller.delbyCarID(carID);
    }

    public void updateCar() throws SQLException {
        System.out.println("Mời bạn nhập carID muốn update!");
        int carID = ScannerUtils.inputIntPositive();

        System.out.println("Mời bạn nhập vào màu xe muốn update!");
        String color = ScannerUtils.inputString();

        System.out.println("Mời bạn nhập vào ghi chú muốn update!");
        String note = ScannerUtils.inputString();
        controller.updateCar(carID, color, note);
    }

    public void demoStoreprocedure() throws SQLException {
        List<Car> cars = controller.demoStoreprocedure();
        printListCar(cars);
    }



    private void printListCar(List<Car> cars) {
        String leftAlignFormat = "| %-3s| %-15s | %-15s | %-15s | %-15s | %-15s |%n";
        System.out.format("+----+-----------------+-----------------+-----------------+-----------------+-----------------%n");
        System.out.format("| id |       Maker     |       Model     |       Date      |       Color     |     Note       |%n");
        System.out.format("+----+-----------------+-----------------+-----------------+-----------------+-----------------%n");

        for (Car car : cars) {
            System.out.format(leftAlignFormat, car.getCarID(), car.getMaker(), car.getModel(), car.getDate(), car.getColor(), car.getNote());
        }

        System.out.format("+----+-----------------+-----------------+-----------------+-----------------+-----------------%n");
    }
}
