package com.vti.backend.service;

import com.vti.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface ICarService {
    List<Car> getAllCar() throws SQLException;

    void addNewCar(Car car) throws SQLException;

    Car findByID(int carID) throws SQLException;

    void delbyCarID(int carID) throws SQLException;

    void updateCar(int carID, String color, String note) throws SQLException;

    List<Car> demoStoreprocedure() throws SQLException;
}
