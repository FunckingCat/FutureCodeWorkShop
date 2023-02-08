package org.module.two.domen;

public abstract class Person implements Announcable {

    protected final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
