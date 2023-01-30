package org.module.two.domen;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class Car {

    public static class CarBrokenException extends Exception { }

    public static int carLimit = 5;
    public static int createdCars = 0;

    private String model;
    private Boolean broken;
    private int durability;

    public Car(String model, Boolean broken, int durability) {

        this.model = model;
        this.broken = broken;
        this.durability = durability;

        createdCars++;
        if (createdCars > carLimit) {
            throw new RuntimeException("Car Limit Overhead");
        }

    }

    public String getModel() {
        return model;
    }

    public Boolean isBroken() {
        return broken;
    }

    private void randomCarBrake() {
        int randomInt  = ThreadLocalRandom.current().nextInt(1000);
        if (randomInt % durability == 0) this.broken = true;
    }

    public void drive() throws CarBrokenException {
        if (isBroken()) {
            throw new CarBrokenException();
        }
        randomCarBrake();
    }

    @Override
    public String toString() {
        return "Машина марки " + getModel() + " и она " + (broken ? "" : " не ") + "сломана";
    }
}
