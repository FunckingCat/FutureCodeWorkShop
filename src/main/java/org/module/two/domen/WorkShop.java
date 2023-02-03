package org.module.two.domen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class WorkShop {

    private static final String[] NAMES = {"Бориска", "Костик", "Светочка", "Геннадий"};

    private final String name;
    private final int maxCapacity;
    private final List<Worker> workers;
    private final Map<Car, Long> cars;

    public WorkShop(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.workers = new ArrayList<>();
        this.cars = new HashMap<>();

        int workersAmount = ThreadLocalRandom.current().nextInt(0, 4) + 1;
        for (int i = 0; i < workersAmount; i++) {
            workers.add(new Worker(NAMES[i]));
        }
    }

    @Override
    public String toString() {
        return "WorkShop{name='%s', maxCapacity=%d, \nworkers=%s, \ncars=%s}"
                .formatted(name,
                        maxCapacity,
                        workers,
                        cars);
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
        if (!cars.containsKey(car))
            cars.put(car, ThreadLocalRandom.current().nextLong(2, 10));
    }

    public Boolean allCarsRepaired() {
        Long sum = 0L;
        for (Long brokenness : cars.values())
            sum += brokenness;
        return sum <= 0;
    }

    public void repairCars() {
        for (Worker worker : workers) {
            for (Car car : cars.keySet()) {
                cars.put(car, cars.get(car) - worker.doWork());
            }
        }
    }
}
