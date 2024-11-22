package org.example;

import java.util.function.Function;

public class StringListProcessor implements Function<String, Integer> {
    @Override
    public Integer apply(String s){
        int count = 0;

        // Прохід по кожному символу в рядку
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }
}
