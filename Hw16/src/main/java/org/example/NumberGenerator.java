package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NumberGenerator {
    public static ArrayList<Integer> generateNumber(Supplier<Integer> supplier){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(supplier.get());
        }
        return result;
    }
}
