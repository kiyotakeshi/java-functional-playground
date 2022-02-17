package com.kiyotakeshi.examples;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Playground2 {

    List<String> course = List.of("spring", "spring boot", "kotlin", "microservices", "kubernetes", "docker", "terraform");

    List<Integer> numbers = List.of(13, 1, 8, 4, 5, 7, 23);

    private static String addCharacterLength(String s) {
        return s + ": character length is " + s.length();
    }

    @Test
    void map() {
        course.stream()
                .map(c -> c + ": character length is " + c.length()) // lambda
                // .map(Playground2::addCharacterLength) // method reference
                .forEach(System.out::println);
    }

    @Test
    void reduce() {
        Integer sum = numbers.stream()
                // .reduce(0, (a, b) -> a + b)
                // .reduce(0, Integer::sum);
                .reduce(0, (a, b) -> {
                    System.out.println(a + " " + b);
                    return a + b;
                });

        System.out.println(sum);

        /**
         jshell> List<Integer> numbers = List.of(13, 1, 8, 4, 5, 7, 23);

         jshell> numbers.stream().reduce(0, (x,y) -> x+y)
         $3 ==> 61

         jshell> numbers.stream().reduce(0, (x,y) -> x-y)
         $4 ==> -61

         jshell> numbers.stream().reduce(0, (x,y) -> x)
         $6 ==> 0

         jshell> numbers.stream().reduce(0, (x,y) -> y)
         $7 ==> 23

         jshell> numbers.stream().reduce(0, (x,y) -> x > y ? x : y)
         $8 ==> 23
         */
    }

    @Test
    void reduce2() {
        System.out.println(
                numbers.stream()
                        .map(x -> x * x)
                        .reduce(0, Integer::sum)
        );
    }

    @Test
    void reduce3() {
        System.out.println(
                numbers.stream()
                        .filter(x -> x % 2 == 0)
                        .reduce(0, Integer::sum)
        );
    }
}
