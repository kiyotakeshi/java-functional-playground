package com.kiyotakeshi.playground1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Mike Popcorn", 20, Gender.MALE),
                new Person("Kendrick West", 33, Gender.FEMALE),
                new Person("Kanye Lamar", 57, Gender.FEMALE),
                new Person("Kid Scott", 14, Gender.MALE),
                new Person("Travis Fresino", 99, Gender.MALE),
                new Person("Anna Jackson", 7, Gender.FEMALE),
                new Person("Megan Cook", 120, Gender.FEMALE)
        );

        // Imperative approach
//        ArrayList<Person> females = new ArrayList<>();
//        for (Person person : persons) {
//            if (Gender.FEMALE.equals(person.getGender())) {
//                females.add(person);
//            }
//        }
//
//        for (Person female : females) {
//            System.out.println(female);
//        }

        // Declarative approach
        // @see https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/package-summary.html

        // Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        List<Person> females = persons.stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()))
                // .filter(personPredicate)
                .collect(Collectors.toList());
        females.forEach(System.out::println);
    }
}
