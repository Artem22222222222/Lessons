package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreedyLoggerTest {

    @Test
    void getInstance() {
        GreedyLogger greedyLogger1 = GreedyLogger.getInstance();
        GreedyLogger greedyLogger2 = GreedyLogger.getInstance();
        assertEquals(greedyLogger1, greedyLogger2);
    }
}