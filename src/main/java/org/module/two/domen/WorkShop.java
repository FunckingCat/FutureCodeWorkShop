package org.module.two.domen;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class WorkShop {

    private static String[] NAMES = {"Бориска", "Костик", "Светочка", "Геннадий"};

    private String name;
    private int maxCapacity;
    private Worker[] workers;
    private Car[] cars;

    public WorkShop(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.workers = new Worker[0];
        this.cars = new Car[0];

        int workersAmount = ThreadLocalRandom.current().nextInt(0, 4) + 1;
        workers = new Worker[workersAmount];
        for (int i = 0; i < workersAmount; i++) {
            workers[i] = new Worker(NAMES[i]);
        }
    }

    @Override
    public String toString() {
        return "WorkShop{name='%s', maxCapacity=%d, \nworkers=%s, \ncars=%s}"
                .formatted(name,
                        maxCapacity,
                        Arrays.toString(workers),
                        Arrays.toString(cars));
    }

    public void acceptCustomer(Client client) {

        Car car = client.getCar();

        System.out.println("Приехал " + client.getName() + " с машиной " + car.getModel());

        if (car.isBroken()) {
            addNewCar(car);
            boolean carAssigned = assingCarToWorker(car);
        } else {
            throw new RuntimeException("Машина не сломана че приперся????");
        }

    }

    private boolean assingCarToWorker(Car car) {

        Worker assignedWorker = null;

        for (Worker worker : workers) {
            if (!worker.isWorkingNow()) {
                assignedWorker = worker;
                break;
            }
        }

        if (assignedWorker == null) {
            return false;
        }

        assignedWorker.setCarRepairing(car);
        assignedWorker.setWorkingNow(true);
        return true;
    }

    private void addNewCar(Car car) {
        Car[] newCars = new Car[cars.length + 1];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        newCars[newCars.length - 1] = car;
        cars = newCars;
    }
}
