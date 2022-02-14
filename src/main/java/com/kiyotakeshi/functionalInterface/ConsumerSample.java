package com.kiyotakeshi.functionalInterface;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerSample {

    public static void main(String[] args) {
//        greetCustomer(new Customer("mike", "0120-444-444"));
        Customer mike = new Customer("mike", "0120-444-444");
        greetCustomerConsumer.accept(mike);
        greetCustomerBiConsumer.accept(mike, false);
    }

    // normal function
//    static void greetCustomer(Customer customer) {
//        System.out.println("Hello " + customer.getName() + ", send your phone: " + customer.getPhoneNumber());
//    }

    // single input argument and return no result
    // @see https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/Consumer.html
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getName()
                    + ", send your phone: " + customer.getPhoneNumber());

    // normal function
//    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
//        System.out.println("Hello " + customer.getName()
//                + ", send your phone: "
//                + (showPhoneNumber ? customer.getPhoneNumber() : "****-***-***"));
//    }

    // two argument and return no result
    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.getName()
                    + ", send your phone: "
                    + (showPhoneNumber ? customer.getPhoneNumber() : "****-***-***"));

    @Data
    @Setter(AccessLevel.NONE)
    public static class Customer {
        private final String name;
        private final String phoneNumber;
    }
}
