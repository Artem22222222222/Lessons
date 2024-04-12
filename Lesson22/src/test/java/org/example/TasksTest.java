package org.example;

import static org.junit.Assert.*;

public class TasksTest {
    @org.junit.Test
    public void task1() {
        assertEquals(Tasks.task1(-1), "Невірно");
        assertEquals(Tasks.task1(0), "Вірно");
        assertEquals(Tasks.task1(1), "Невірно");
    }

    @org.junit.Test
    public void task2() {
        assertEquals(Tasks.task2(-1), "Невірно");
        assertEquals(Tasks.task2(0), "Невірно");
        assertEquals(Tasks.task2(1), "Вірно");
    }

    @org.junit.Test
    public void task3() {
        assertEquals(Tasks.task3(-1), "Вірно");
        assertEquals(Tasks.task3(0), "Невірно");
        assertEquals(Tasks.task3(1), "Невірно");
    }

    @org.junit.Test
    public void task4() {
        assertEquals(Tasks.task4(-1), "Невірно");
        assertEquals(Tasks.task4(0), "Вірно");
        assertEquals(Tasks.task4(1), "Вірно");
    }

    @org.junit.Test
    public void task5() {
        assertEquals(Tasks.task5(-1), "Вірно");
        assertEquals(Tasks.task5(0), "Вірно");
        assertEquals(Tasks.task5(1), "Невірно");
    }

    @org.junit.Test
    public void task6() {
        assertEquals(Tasks.task6(-1), "Вірно");
        assertEquals(Tasks.task6(0), "Невірно");
        assertEquals(Tasks.task6(1), "Вірно");
    }

    @org.junit.Test
    public void task7() {
        assertEquals(Tasks.task7("test"), "Вірно");
        assertEquals(Tasks.task7("lsgjrk"), "Невірно");
        assertEquals(Tasks.task7(1), "Невірно");
    }

    @org.junit.Test
    public void task8() {
        assertEquals(Tasks.task8("1"), "Вірно");
        assertEquals(Tasks.task8("lsgjrk"), "Невірно");
        assertEquals(Tasks.task8(1), "Невірно");
    }

    @org.junit.Test
    public void task9_1() {
        assertEquals(Tasks.task9_1(true), "Вірно");
        assertEquals(Tasks.task9_1(false), "Невірно");
    }

    @org.junit.Test
    public void task9_2() {
        assertEquals(Tasks.task9_2(true), "Вірно");
        assertEquals(Tasks.task9_2(false), "Невірно");
    }

    @org.junit.Test
    public void task10_1() {
        assertEquals(Tasks.task10_1(true), "Невірно");
        assertEquals(Tasks.task10_1(false), "Вірно");
    }

    @org.junit.Test
    public void task10_2() {
        assertEquals(Tasks.task10_2(true), "Невірно");
        assertEquals(Tasks.task10_2(false), "Вірно");
    }

    @org.junit.Test
    public void task11() {
        assertEquals(Tasks.task11(1), "Вірно");
        assertEquals(Tasks.task11(6), "Невірно");
        assertEquals(Tasks.task11(-1), "Невірно");
        assertEquals(Tasks.task11(0), "Невірно");
    }

    @org.junit.Test
    public void task12() {
        assertEquals(Tasks.task12(2), 9);
        assertEquals(Tasks.task12(6), 0);
        assertEquals(Tasks.task12(-1), 0);
        assertEquals(Tasks.task12(0), 7);
    }

    @org.junit.Test
    public void task13() {
        assertEquals(Tasks.task13(-1, 5), 4);
        assertEquals(Tasks.task13(0, 0), 0);
        assertEquals(Tasks.task13(1, 3), 4);
        assertEquals(Tasks.task13(2, -5), 7);
    }

    @org.junit.Test
    public void task14() {
        assertEquals(Tasks.task14(5, 8), "Вірно");
        assertEquals(Tasks.task14(0, 0), "Невірно");
        assertEquals(Tasks.task14(15, 6), "Вірно");
        assertEquals(Tasks.task14(3, -5), "Вірно");
    }

    @org.junit.Test
    public void task15() {
        assertEquals(Tasks.task15(1), "зима");
        assertEquals(Tasks.task15(2), "весна");
        assertEquals(Tasks.task15(3), "літо");
        assertEquals(Tasks.task15(4), "осінь");
    }
}