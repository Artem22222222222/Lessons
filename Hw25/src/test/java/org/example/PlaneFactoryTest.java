package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneFactoryTest {

    @Test
    void createTransport() {
        PlaneFactory planeFactory = new PlaneFactory();
        Transport plane = planeFactory.createTransport();
        assert plane.getClass() == Plane.class;
        assert plane.move(20);
        assert !plane.move(1000);
    }
}