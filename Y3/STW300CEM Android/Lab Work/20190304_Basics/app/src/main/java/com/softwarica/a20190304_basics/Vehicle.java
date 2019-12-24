package com.softwarica.a20190304_basics;

public class Vehicle {
    int id;
    String plateNo;
    String brand;
    int noOfWheels;

    public Vehicle(int id, String plateNo, String brand, int noOfWheels) {
        this.id = id;
        this.plateNo = plateNo;
        this.brand = brand;
        this.noOfWheels = noOfWheels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plateNo='" + plateNo + '\'' +
                ", brand='" + brand + '\'' +
                ", noOfWheels=" + noOfWheels +
                '}';
    }
}
