import java.util.*;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Integer[] a = {1, 5, 2, 68, 100};
    IntStream intStream = Arrays.stream(a).mapToInt(Integer::intValue);
    Main main = new Main();

    @org.junit.jupiter.api.Test
    void task1() {
        main.task1(intStream);
    }

    @org.junit.jupiter.api.Test
    void task2() {
        main.task2(intStream);
    }

    @org.junit.jupiter.api.Test
    void task3() {
        main.task3(intStream);
    }

    @org.junit.jupiter.api.Test
    void task4() {
        main.task4(intStream);
    }

    @org.junit.jupiter.api.Test
    void task5() {
        main.task5(intStream);
    }
}