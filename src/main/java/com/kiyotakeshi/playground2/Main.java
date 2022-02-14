package com.kiyotakeshi.playground2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = getPersons();

        persons.stream()
                .map(Person::getGender)
                // .collect(Collectors.toList())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-------------------");
        // input is Person, output is String
        Function<Person, String> getName = Person::getName;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        persons.stream()
                .map(getName)
                // .mapToInt(name -> name.length())
                .mapToInt(length)
                .forEach(println);

        System.out.println("-------------------");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        boolean containsOnlyFemales = persons.stream()
                // .allMatch(personPredicate);
                .anyMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        System.out.println("-------------------");
    }

    private static List<Person> getPersons() {
        return List.of(
                new Person("Mike Popcorn", 20, Gender.MALE),
                new Person("Kendrick West", 33, Gender.FEMALE),
                new Person("Kanye Lamar", 57, Gender.FEMALE),
                new Person("Kid Scott", 14, Gender.MALE),
                new Person("Travis Fresino", 99, Gender.MALE),
                new Person("Anna Jackson", 7, Gender.FEMALE),
                new Person("Megan Cook", 110, Gender.FEMALE)
        );
    }
}
