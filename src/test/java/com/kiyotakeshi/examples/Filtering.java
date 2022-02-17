package com.kiyotakeshi.examples;

import com.kiyotakeshi.examples.beans.Car;
import com.kiyotakeshi.examples.mockdata.SampleData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {

    @Test
    void filter() throws IOException {
        // set up(arrange)
        List<Car> cars = SampleData.getCars();

        // Predicate<Car> pricePredicate = car -> car.getPrice() < 15_000.00;
        // Predicate<Car> colorPredicate = car -> car.getColor().equals("Black");
        List<Car> carsLessThan15kAndBlack = cars.stream()
                .filter(car -> car.getPrice() < 15_000.00)
                .filter(car -> car.getColor().equals("Black"))
                .collect(Collectors.toList());

        // exercise(act)
        carsLessThan15kAndBlack.forEach(System.out::println);
    }
}
