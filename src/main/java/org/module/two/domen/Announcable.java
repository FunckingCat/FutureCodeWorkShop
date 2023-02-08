package org.module.two.domen;

public interface Announcable {

    void announce();

    default void scream() {
        System.out.println("AAAAAAA");
    }

}
