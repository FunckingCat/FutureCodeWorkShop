package org.module.two.domen;

import javax.xml.transform.Source;

public class Client extends Person {
    private Car car;

    public Client(String name, Car car) {

        super(name);

        if (car == null) {
            throw new RuntimeException("Car cant be null");
        }

        this.car = car;

    }

    public void drive() throws Car.CarBrokenException {
        car.drive();
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void announce() {
//        super.announce();
        System.out.println("Client " + name);
    }
}
