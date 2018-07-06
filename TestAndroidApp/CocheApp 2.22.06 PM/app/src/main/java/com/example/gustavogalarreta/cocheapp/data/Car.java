package com.example.gustavogalarreta.cocheapp.data;

public class Car {
    String id;
    String name;
    String brand;
    int doors;
    int wheels;

    public Car() {
    }


    public Car(String name, String brand, int doors, int wheels) {
        this.brand = brand;
        this.name = name;
        this.doors = doors;
        this.wheels = wheels;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

}
