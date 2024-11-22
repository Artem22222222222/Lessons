package org.example;

import java.util.function.Function;


public class StringListProcessorUTIL {
    public static <T> T upperCaseCounter(String s, Function<String, T> count){
        return count.apply(s);
    }

}
