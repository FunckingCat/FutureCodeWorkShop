package org.module.two;

import org.module.two.domen.Car;
import org.module.two.domen.Client;
import org.module.two.domen.WorkShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static WorkShop workShop;

    public static void main(String[] args) {

        workShop = new WorkShop("У Бориски", 3);

        Client client = new Client("Санечка", new Car("Лендровер", false, 35));

        while (true) {
            try {
                client.drive();
            } catch (Car.CarBrokenException e) {
                break;
            }
        }

        workShop.acceptCustomer(client);

        while (!workShop.allCarsRepaired()) {
            workShop.repairCars();
        }

        System.out.println(workShop);

    }

}