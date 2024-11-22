package org.example;

import java.util.stream.Stream;

public class StreamHelper {
    private static double sum;
    private static double count = 0;

    public static double productPriceAverage(Stream<Product> stream){
        count = stream.peek(x-> sum += x.getPrice()).count();
        return sum/count;
    }
}
