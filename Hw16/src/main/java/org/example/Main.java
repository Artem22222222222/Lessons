package org.example;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MathOperation m = new MathOperation(){
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        };
        System.out.println(m.operate(5, 9));


        StringManipulator toUpperCaseConvertor = t -> t.toUpperCase();
        System.out.println(toUpperCaseConvertor.toUpperCase("hello"));

        Integer i = StringListProcessorUTIL.upperCaseCounter("gifjguYGYUH", new StringListProcessor());
        System.out.println(i);

        ArrayList<Integer> a = NumberGenerator.generateNumber(() -> new RandomNumberGenerator().generateRandomNumber(5, 10));
        a.stream().forEach(System.out::println);



    }
}