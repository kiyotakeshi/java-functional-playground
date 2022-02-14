package com.kiyotakeshi.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionSample {

    public static void main(String[] args) {
        System.out.println("Function takes 1 argument and produces 1 result");
        // int increment = increment(0);
        int increment = incrementByOneFunction.apply(1);
        System.out.println(increment);

        System.out.println("BiFunction takes 2 argument and produces 1 result");
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(2, 5));
    }

    // normal function
    // one argument and one single output, so you can convert function
    // @see https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/Function.html
//    static int increment(int number) {
//        return number += 1;
//    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    // normal function
//    static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {
//        return (number + 1) * numberToMultiplyBy;
//    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
}
