package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Converter");
        System.out.println(frtToCls(212));
    }
    public static double frtToCls(int frt){
        return (frt-32)/1.8;
    }
}