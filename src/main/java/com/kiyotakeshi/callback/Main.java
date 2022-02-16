package com.kiyotakeshi.callback;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        hello("mike", "popcorn", value -> {
            System.out.println("no lastName provided for " + value);
        });

        System.out.println("--------------------");

        hello("kendrick", null, value -> {
            System.out.println("no lastName provided for " + value);
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }
}
