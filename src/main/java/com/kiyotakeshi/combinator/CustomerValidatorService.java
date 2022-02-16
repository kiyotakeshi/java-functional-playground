package com.kiyotakeshi.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.contains("090");
    }

    private boolean isAdult(LocalDate birthDay) {
        return Period.between(birthDay, LocalDate.now()).getYears() > 20;
    }

    public boolean isValid(Customer customer) {
        return isEmailValid(customer.getEmail()) &&
                isPhoneNumberValid(customer.getPhoneNumber()) &&
                isAdult(customer.getBirthDay());
    }
}
