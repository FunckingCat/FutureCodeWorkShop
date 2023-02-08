package org.module.two;

import org.module.two.domen.Announcable;
import org.module.two.domen.Car;
import org.module.two.domen.Client;
import org.module.two.domen.Person;
import org.module.two.domen.Screamer;
import org.module.two.domen.WorkShop;
import org.module.two.domen.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static WorkShop workShop;

    public static void main(String[] args) {

        workShop = new WorkShop("У Бориски", 3);

        Person client = new Client("Санечка", new Car("Лендровер", false, 35));
        Worker worker = new Worker("Данечка");

        Announcable screamer = new Screamer();

        Announcable announcable = new Announcable() {
            @Override
            public void announce() {
                System.out.println("ANONYM");
            }
        };

        Person vava = new Person("VOVCHKA") {
            @Override
            public void announce() {
                System.out.println("VOVCHAK ANONYM");
            }
        };

//        screamer.announce();

        List<Announcable> persons = new ArrayList<>();

        persons.add(client);
        persons.add(worker);
        persons.add(screamer);
        persons.add(announcable);
        persons.add(vava);

        for (Announcable person : persons) {
            person.announce();
            person.scream();
            if (person instanceof Client) {
                System.out.println(((Client) person).getCar().toString());;
            } else if (person instanceof Worker) {
                System.out.println("Hf,jnzuf");
            }
        }


//        while (true) {
//            try {
//                client.drive();
//            } catch (Car.CarBrokenException e) {
//                break;
//            }
//        }
//
//        workShop.acceptCustomer(client);
//
//        while (!workShop.allCarsRepaired()) {
//            workShop.repairCars();
//        }
//
//        System.out.println(workShop);

    }

}