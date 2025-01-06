package org.example;

import java.util.ArrayList;
import java.util.function.Supplier;

public class NumberGenerator {
    public static int[] generateNumber(Supplier<Integer> supplier, int count){
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = supplier.get();
        }
        return result;
    }
}

