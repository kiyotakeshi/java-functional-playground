package com.kiyotakeshi.examples.beans;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class PersonDTO {

    private final Integer id;
    private final String name;
    private final Integer age;

    public static PersonDTO map(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getAge());
    }
}
