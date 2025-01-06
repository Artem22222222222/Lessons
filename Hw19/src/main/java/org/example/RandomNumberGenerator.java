package org.example;


import java.util.Random;

public class RandomNumberGenerator {
    int generateRandomNumber(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }
}