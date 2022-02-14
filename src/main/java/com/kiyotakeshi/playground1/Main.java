package com.kiyotakeshi.playground1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = getPersons();

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

        // ------------------------------------
        // Declarative approach
        // @see https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/package-summary.html

        // filter
        // Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
        List<Person> females = persons.stream()
                .filter(person -> Gender.FEMALE.equals(person.getGender()))
                // .filter(personPredicate)
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        System.out.println("-------------------");
        System.out.println("sort");
        List<Person> sortedPersons = persons.stream()
                // .sorted(Comparator.comparing(Person::getAge))
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sortedPersons.forEach(System.out::println);

        System.out.println("-------------------");
        System.out.println("all match");
        boolean allMatch = persons.stream()
                // .allMatch(person -> person.getAge() > 5);
                .allMatch(person -> person.getAge() > 8);
        System.out.println(allMatch);

        System.out.println("-------------------");
        System.out.println("any match");
        boolean anyMatch = persons.stream()
                .anyMatch(person -> person.getAge() > 8);
        System.out.println(anyMatch);

        System.out.println("-------------------");
        System.out.println("none match");
        boolean noneMatch = persons.stream()
                .noneMatch(person -> person.getName().equals("Suzuki"));
        System.out.println(noneMatch);

        // ------------------------------------
        // max
        System.out.println("-------------------");
        System.out.println("max");
//        Optional<Person> max = persons.stream()
//                .max(Comparator.comparing(Person::getAge));
        persons.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // ------------------------------------
        // min
        System.out.println("-------------------");
        System.out.println("min");
        persons.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // ------------------------------------
        // group
        System.out.println("-------------------");
        System.out.println("group");
        Map<Gender, List<Person>> personsGroupByGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        personsGroupByGender.forEach((gender, person) -> {
            System.out.println(gender);
            person.forEach(System.out::println);
            System.out.println();
        });

        // ------------------------------------
        // chain
        System.out.println("-------------------");
        System.out.println("chain");
        Optional<String> oldestAgeFemaleName = persons.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestAgeFemaleName.ifPresent(System.out::println);
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
