package org.module.two.domen;

import java.util.Arrays;
import java.util.List;

public class Worker extends Person {

    private static final Integer EFFECT = 2;
    private List<String> carModelsListAvalibleToRepair;

    private Boolean workingNow;
    private Car carRepairing;

    public Worker(String name) {
        super(name);
        this.workingNow = false;
    }

    @Override
    public void announce() {
//        super.announce();
        System.out.println("Worker " + name);
    }

    @Override
    public String toString() {
        return "Рабочий{name='%s', %s, workingNow=%s, %s}"
                .formatted(name, carModelsListAvalibleToRepair, workingNow, carRepairing);
    }

    public Car getCarRepairing() {
        return carRepairing;
    }

    public void setCarRepairing(Car carRepairing) {
        this.carRepairing = carRepairing;
    }

    public Boolean isWorkingNow() {
        return workingNow;
    }

    public void setWorkingNow(Boolean workingNow) {
        this.workingNow = workingNow;
    }

    public Integer doWork() {
        System.out.println(name + ": Чиню е мае");
        return EFFECT;
    }
}
