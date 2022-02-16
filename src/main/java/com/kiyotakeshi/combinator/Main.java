package com.kiyotakeshi.combinator;

import java.time.LocalDate;

import static com.kiyotakeshi.combinator.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        var customer = new Customer(
                "mike",
                "mike@example.com",
                "090-xxx-xxx",
                LocalDate.of(2000, 11, 10));

        var customer2 = new Customer(
                "mike",
                "mike#example.com",
                "090-xxx-xxx",
                LocalDate.of(2000, 11, 10));

        // System.out.println(new CustomerValidatorService().isValid(customer));
        // System.out.println(new CustomerValidatorService().isValid(customer2));

        // using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
                // .apply(customer2);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalArgumentException(result.name());
        }
    }
}
