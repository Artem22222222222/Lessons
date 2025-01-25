package org.example;

public class Car implements Transport{
    @Override
    public boolean move(int distance) {
        if (distance < 50) {
            return true;
        }else {
            return false;
        }
    }
}
