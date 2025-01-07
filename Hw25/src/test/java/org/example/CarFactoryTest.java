package org.example;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @org.junit.jupiter.api.Test
    void createTransport() {
        CarFactory carFactory = new CarFactory();
        Transport car = carFactory.createTransport();
        assert car.getClass() == Car.class;
        assert car.move(20);
        assert !car.move(200);
    }
}