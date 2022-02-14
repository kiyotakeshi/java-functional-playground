package com.kiyotakeshi.optinals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        // Object optionalValue = Optional.ofNullable(null)
        Object optionalValue = Optional.ofNullable("hello")
                .orElseGet(() -> "default value");

        System.out.println(optionalValue);

        // Supplier takes no argument and supplies a value
        // Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Object optionalValue2 = Optional.ofNullable("hello")
                // .orElseThrow(exception);
                .orElseThrow(() -> new IllegalStateException("exception"));

        Optional.ofNullable("test@example.com")
                .ifPresent(email -> {
                    System.out.println("Sending email to " + email);
                });

        Optional.of("test2@example.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Could not send email"));
    }
}
