package com.vti.entity;

public class Car {
    private int carID;
    private Maker maker;
    private String model;
    private String date;
    private String color;
    private String note;

    public Car() {
    }

    public Car(int id, Maker maker, String model, String date, String color, String note) {
        this.carID = id;
        this.maker = maker;
        this.model = model;
        this.date = date;
        this.color = color;
        this.note = note;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carID +
                ", maker=" + maker +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", color='" + color + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
