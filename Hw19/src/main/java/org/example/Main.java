package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ElementNotFoundException {
        int[] randomList = NumberGenerator.generateNumber(() -> new RandomNumberGenerator().generateRandomNumber(5, 10), 10);
        int[] sortedList = ArrayUtils.mergeSort(randomList);
        int result = ArrayUtils.binarySearch(sortedList, sortedList[4]);
        System.out.println(Arrays.toString(sortedList));
        System.out.println(result);
//        int[] a = {5, 55, 8, 5, 4, 57, 64, 45, 2};
//        int[] b = {25, 12};
//        int[] c = ArrayUtils.mergeSort(a);
//        Arrays.stream(c).forEach(x -> System.out.print(x+" "));
    }
}