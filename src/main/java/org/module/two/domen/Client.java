package org.module.two.domen;

public class Client {
    private String name;
    private Car car;

    public Client(String name, Car car) {

        if (car == null) {
            throw new RuntimeException("Car cant be null");
        }

        this.name = name;
        this.car = car;

    }

    public void drive() throws Car.CarBrokenException {
        car.drive();
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }
}
