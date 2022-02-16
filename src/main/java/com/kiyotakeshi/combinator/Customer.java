package com.kiyotakeshi.combinator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter(AccessLevel.NONE)
public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate birthDay;
}
