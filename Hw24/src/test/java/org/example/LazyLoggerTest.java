package org.example;

import static org.junit.jupiter.api.Assertions.*;

class LazyLoggerTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        LazyLogger lazyLogger1 = LazyLogger.getInstance();
        LazyLogger lazyLogger2 = LazyLogger.getInstance();
        assertEquals(lazyLogger1, lazyLogger2);
    }
}