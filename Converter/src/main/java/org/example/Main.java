package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Converter");
        System.out.println(frtToCls(212));
        System.out.println(clsToFrt(100));
    }
    public static double frtToCls(double frt){
        return (frt-32)/1.8;
    }
    public static double clsToFrt(double cls){
        return cls*1.8+32;
    }
}