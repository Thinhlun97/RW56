package com.vti.backend.repository;

import com.vti.entity.Car;
import com.vti.entity.Maker;
import com.vti.utils.JDBCutils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    public List<Car> getAllCar() throws SQLException {
        String sql = "SELECT * FROM jdbc.car";
        Statement statement = JDBCutils.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        JDBCutils.closeConnection();
        List<Car> cars = new ArrayList<>();
        while (resultSet.next()) {
            int carID = resultSet.getInt("CarID");
            String maker = resultSet.getString("Maker");
            String model = resultSet.getString("Model");
            String year = resultSet.getString("Year");
            String color = resultSet.getString("color");
            String note = resultSet.getString("note");

            Car car = new Car(carID, Maker.valueOf(maker), model, year, color, note);


            cars.add(car);

        }

        return cars;
    }

    public void addNewCar(Car car) throws SQLException {
        String sql = "insert into Car (Maker,Model,Year,color,Note) values(?, ? ,? ,? ,?)";
        PreparedStatement preparedStatement = JDBCutils.getConnect().prepareStatement(sql);
        preparedStatement.setString(1, car.getMaker().name());
        preparedStatement.setString(2, car.getModel());
        preparedStatement.setString(3, car.getDate());
        preparedStatement.setString(4, car.getColor());
        preparedStatement.setString(5, car.getNote());

        int rs = preparedStatement.executeUpdate();
        JDBCutils.closeConnection();
        System.out.println("Đã thêm mới  " + rs + " bản ghi !");
    }


    public Car finByID(int carid) throws SQLException {
        String sql = "Select * from JDBC.Car where carid = ?";
        PreparedStatement preparedStatement = JDBCutils.getConnect().prepareStatement(sql);
        preparedStatement.setInt(1, carid);
        ResultSet resultSet = preparedStatement.executeQuery();
        JDBCutils.closeConnection();
        Car car = new Car();

        if (resultSet.next()) {
            car.setCarID(carid);
            car.setModel(resultSet.getString("model"));
            car.setDate(resultSet.getString("year"));
            car.setColor(resultSet.getString("color"));
            car.setNote(resultSet.getString("note"));
            String makerString = resultSet.getString("maker");
            car.setMaker(Maker.valueOf(makerString));
        } else {
            return null;
        }
        return car;
    }

    public void delByID(int carID) throws SQLException {
        Car car = finByID(carID);
        if (car == null) {
            System.out.println("Car không tồn tại !!!");
        } else {
            String sql = "DELETE FROM JDBC.Car WHERE carid = ?";
            PreparedStatement preparedStatement = JDBCutils.getConnect().prepareStatement(sql);
            preparedStatement.setInt(1, carID);
            int rs = preparedStatement.executeUpdate();
            JDBCutils.closeConnection();
            if (rs == 0) {
                System.out.println("Có lỗi xảy ra không xóa được!");
            } else {
                System.out.println("Bạn đã xóa thành công " + rs + " bản ghi!!");
            }
        }
    }

    public void updateCar(int carID, String color, String note) throws SQLException {
        String sql = "update Car SET color = ? , note = ? where carID = ?";
        PreparedStatement preparedStatement = JDBCutils.getConnect().prepareStatement(sql);
        preparedStatement.setInt(3, carID);
        preparedStatement.setString(1, color);
        preparedStatement.setString(2, note);

        int rs = preparedStatement.executeUpdate();
        JDBCutils.closeConnection();
        if (rs == 0) {
            System.out.println("Car không tồn tại! ");
        } else {
            System.out.println("Đã update thành công  " + rs + " bản ghi !");
        }
    }

    public List<Car> demoStoreprocedure() throws SQLException {
        String sql = "call demoStore();";
        CallableStatement callableStatement = JDBCutils.getConnect().prepareCall(sql);
        ResultSet resultSet = callableStatement.executeQuery();

        List<Car> cars = new ArrayList<>();
        while (resultSet.next()) {
            int carID = resultSet.getInt("CarID");
            String maker = resultSet.getString("Maker");
            String model = resultSet.getString("Model");
            String year = resultSet.getString("Year");
            String color = resultSet.getString("color");
            String note = resultSet.getString("note");

            Car car = new Car(carID, Maker.valueOf(maker), model, year, color, note);


            cars.add(car);
        }
            JDBCutils.closeConnection();
            return cars;
    }
}
