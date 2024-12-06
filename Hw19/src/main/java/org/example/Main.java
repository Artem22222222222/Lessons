package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ElementNotFoundException, NoSuchMethodException {
//        int[] randomList = NumberGenerator.generateNumber(() -> new RandomNumberGenerator().generateRandomNumber(5, 10), 10);
//        int[] sortedList = ArrayUtils.mergeSort(randomList);
//        int result = ArrayUtils.binarySearch(sortedList, sortedList[4]);
//        System.out.println(Arrays.toString(sortedList));
//        System.out.println(result);
//        int[] a = {5, 55, 8, 5, 4, 57, 64, 45, 2};
//        int[] b = {25, 12};
//        int[] c = ArrayUtils.mergeSort(a);
//        Arrays.stream(c).forEach(x -> System.out.print(x+" "));

        Class<? extends ArrayUtils> aClass = ArrayUtils.class;
        Method method1 = aClass.getMethod("mergeSort", int[].class);
        MethodInfo methodInfo1 = method1.getAnnotation(MethodInfo.class);
        Author author1 = method1.getAnnotation(Author.class);
        System.out.println(author1.name());
        System.out.println(methodInfo1.name());
        System.out.println(methodInfo1.type());
        System.out.println(methodInfo1.description() + "\n");

        Method method2 = aClass.getMethod("binarySearch", int[].class, int.class);
        MethodInfo methodInfo2 = method2.getAnnotation(MethodInfo.class);
        Author author2 = method2.getAnnotation(Author.class);
        System.out.println(author2.name());
        System.out.println(methodInfo2.name());
        System.out.println(methodInfo2.type());
        System.out.println(methodInfo2.description());
    }
}