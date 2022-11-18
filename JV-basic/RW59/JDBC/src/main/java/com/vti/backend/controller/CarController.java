package com.vti.backend.controller;

import com.vti.backend.service.CarService;
import com.vti.entity.Car;

import java.sql.SQLException;
import java.util.List;

public class CarController {
    CarService carService = new CarService();

    public List<Car> getAllCar() throws SQLException {
        return carService.getAllCar();
    }

    public void addNewCar(Car car) throws SQLException {
        carService.addNewCar(car);
    }

    public Car findByID(int carID) throws SQLException {
        return carService.findByID(carID);
    }

    public void delbyCarID(int carID) throws SQLException {
        carService.delbyCarID(carID);
    }

    public void updateCar(int carID, String color, String note) throws SQLException {
        carService.updateCar(carID, color, note);
    }

    public List<Car> demoStoreprocedure() throws SQLException {
        return carService.demoStoreprocedure();
    }
}
