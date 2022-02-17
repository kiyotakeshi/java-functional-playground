package com.kiyotakeshi.examples;

import com.kiyotakeshi.beans.Person;
import com.kiyotakeshi.beans.PersonDTO;
import com.kiyotakeshi.mock.SampleData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSample {

    @Test
    void map() throws IOException {
        // set up(arrange)
        List<Person> persons = SampleData.getPersons();

        List<PersonDTO> personDtos = persons.stream()
                .filter(p -> p.getAge() > 20)
                .map(p -> new PersonDTO(
                        p.getId(), p.getFirstName(), p.getAge()
                ))
                .collect(Collectors.toList());

        // exercise(act)
        personDtos.forEach(System.out::println);

        // verify(assert)
        // assertThat(personDtos.size()).isEqualTo(persons.size());
        assertThat(personDtos.size()).isLessThan(persons.size());
    }
}
