package com.kiyotakeshi.functionalInterface;

import java.util.function.Predicate;

public class PredicateSample {

    public static void main(String[] args) {
//        System.out.println(isPhoneNumberValid("0120-444-444"));
//        System.out.println(isPhoneNumberValid("090-xxx-xxx"));
        System.out.println(isPhoneNumberValidPredicate.test("0120-444-444"));
        System.out.println(isPhoneNumberValidPredicate.test("090-xxx-xxx"));

        System.out.println("Is phone number valid and contains number 4 = "
                + isPhoneNumberValidPredicate.and(containersNumber4).test("0120-444-444"));

        System.out.println("Is phone number valid or contains number 4 = "
                + isPhoneNumberValidPredicate.or(containersNumber4).test("0120-333-333"));
    }

//    static boolean isPhoneNumberValid(String phoneNumber) {
//        return phoneNumber.startsWith("0120") && phoneNumber.length() == 12;
//    }

    // represents a predicate of one argument
    // @see https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/Predicate.html
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("0120") && phoneNumber.length() == 12;

    static Predicate<String> containersNumber4 = phoneNumber -> phoneNumber.contains("4");
}
