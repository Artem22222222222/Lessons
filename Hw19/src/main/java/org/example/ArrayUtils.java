package org.example;

public class ArrayUtils {
    static boolean isEven;
    public static int[] mergeSort(int[] array) throws ElementNotFoundException {
        isEven = array.length%2 == 0;
        return spliter(split(array, 1), split(array, 2));
    }
    private static int[] spliter(int[] leftArray, int[] rightArray) throws ElementNotFoundException {
        if (leftArray.length == 1 && rightArray.length == 1){
            return mergeSort(leftArray, rightArray);
        }else if (leftArray.length == 1){
            return mergeSort(leftArray, spliter(split(rightArray, 1), split(rightArray, 2)));
        }else {
            return mergeSort(spliter(split(leftArray, 1), split(leftArray, 2)), spliter(split(rightArray, 1), split(rightArray, 2)));
        }
    }
    private static int[] split(int[] array, int part) throws ElementNotFoundException {
        int j = 0;
        int[] result;
        if (array.length == 1){
            return array;
        } else if (part == 1){
            result = new int[array.length/2];
            for (int i = 0; i < result.length; i++) {
                result[i] = array[i];
            }
        } else if (part == 2){
//            if (isEven) {
//                result = new int[array.length / 2];
//            }else {
//                result = new int[array.length / 2 + 1];
//            }
            result = new int[array.length%2 == 0 ? array.length / 2 : array.length / 2 + 1];
            for (int i = array.length/2; i < array.length; i++) {
                result[j] = array[i];
                j++;
            }
        }else {
            throw new ElementNotFoundException();
        }
        return result;

    }
    private static int[] mergeSort(int[] leftArray, int[] rightArray){
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        int[] result = new int[leftArray.length + rightArray.length];
        while (true) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                result[resultIndex] = leftArray[leftIndex];
                leftIndex++;
                resultIndex++;
                if (leftIndex == leftArray.length) {
                    for (int i = rightIndex; i < rightArray.length; i++) {
                        result[resultIndex] = rightArray[i];
                        resultIndex++;
                    }
                    return result;
                }
            } else {
                result[resultIndex] = rightArray[rightIndex];
                rightIndex++;
                resultIndex++;
                if (rightIndex == rightArray.length) {
                    for (int i = leftIndex; i < leftArray.length; i++) {
                        result[resultIndex] = leftArray[i];
                        resultIndex++;
                    }
                    return result;
                }
            }
        }
    }
    public static int binarySearch(int[] array, int target) throws ElementNotFoundException {
        int currentIndex = array.length/2;
        while (true){
            if (target == array[currentIndex]){
                return currentIndex;
            }else if (target < array[currentIndex]){
                if (currentIndex > array.length/2){
                    throw new ElementNotFoundException();
                }
                currentIndex = currentIndex/2;
            }else if (target > array[currentIndex]){
                if (currentIndex < array.length/2){
                    throw new ElementNotFoundException();
                }
                currentIndex = currentIndex + currentIndex/2;
            }
        }
    }
}
