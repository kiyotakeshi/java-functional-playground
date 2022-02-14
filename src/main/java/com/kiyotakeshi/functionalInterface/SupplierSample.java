package com.kiyotakeshi.functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class SupplierSample {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    // represents a supplier of results
    // @see https://docs.oracle.com/javase/jp/8/docs/api/java/util/function/Supplier.html
    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/sample";
    }

    // static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:5432/sample";
    static Supplier<List<String>> getDBConnectionUrlSupplier = () ->
            List.of(
                    "jdbc://localhost:5432/sample",
                    "jdbc://localhost:5432/playground"
            );
}
