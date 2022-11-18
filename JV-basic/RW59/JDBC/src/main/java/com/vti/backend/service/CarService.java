package com.vti.backend.service;

import com.vti.backend.repository.CarRepository;
import com.vti.entity.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService implements ICarService {
    CarRepository repository = new CarRepository();

    @Override
    public List<Car> getAllCar() throws SQLException {
        return repository.getAllCar();
    }

    @Override
    public void addNewCar(Car car) throws SQLException {
        repository.addNewCar(car);
    }

    @Override
    public Car findByID(int carID) throws SQLException {
        return repository.finByID(carID);
    }

    @Override
    public void delbyCarID(int carID) throws SQLException {
        repository.delByID(carID);
    }

    @Override
    public void updateCar(int carID, String color, String note) throws SQLException {
        repository.updateCar(carID, color, note);
    }

    @Override
    public List<Car> demoStoreprocedure() throws SQLException {
        return repository.demoStoreprocedure();
    }


}
