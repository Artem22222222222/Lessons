package org.example;

// Main.java
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Stream<Product> result1 = products
                .stream()
                .filter(x -> Objects.equals(x.getCategory(), "Electronics"));
        double averagePrice1 = StreamHelper.productPriceAverage(result1);

        Stream<Product> result2 = products
                .stream()
                .filter(x -> Objects.equals(x.getCategory(), "Appliances"));
        double averagePrice2 = StreamHelper.productPriceAverage(result2);

        DoubleStream maxAverage = DoubleStream.of(averagePrice1, averagePrice2);
        OptionalDouble maxAverageResult = maxAverage.max();

        System.out.println("Electronics: " + averagePrice1);
        System.out.println("Appliances: " + averagePrice2);
        System.out.println(maxAverageResult.getAsDouble() == averagePrice1 ? "Electronics" : "Appliances");
    }
}
