package org.example;


import java.util.Random;
import java.util.function.Supplier;

public class RandomNumberGenerator {
    int generateRandomNumber(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }
}
