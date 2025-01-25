package org.example;

public class Plane implements Transport{
    @Override
    public boolean move(int distance) {
        if (distance < 500) {
            return true;
        }else {
            return false;
        }
    }
}