package org.module.two.domen;

import java.util.Arrays;

public class Worker {

    private static Integer TIME_TO_REPAIR_CAR = 5;

    private String name;
    private String[] carModelsListAvalibleToRepair;

    private Boolean workingNow;
    private Car carRepairing;

    public Worker(String name) {
        this.name = name;
        this.workingNow = false;
    }

    @Override
    public String toString() {
        return "Рабочий{name='%s', %s, workingNow=%s, %s}"
                .formatted(name, Arrays.toString(carModelsListAvalibleToRepair), workingNow, carRepairing);
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
}
