package com.kiyotakeshi.playground1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
}
