package com.dev.day1;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 10, 23, 54, 74, 12};

        //average
       /* double average = Arrays.stream(numbers).average().orElse(0.0);

        int secondLargest =Arrays.stream(numbers).distinct().boxed().sorted((a,b)->b-a).skip(1).findFirst().orElse(-1);

        int secondSmallest =Arrays.stream(numbers).distinct().boxed().sorted().skip(1).findFirst().orElse(-1);

*/
        //intersection of two arrays

        int[] array1 = {1, 0, 5, 0, 6, 8, 0, 5, 0};
        // moveZerosToEnd(array1);
        moveZerosToStart(array1);
        System.out.println(Arrays.toString(array1));

    }

    private static void moveZerosToStart(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0;

        // Move non-zero elements to the end of the array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex++] = temp;
            }
        }
    }


    private static void moveZerosToEnd(int[] arr) {
        int nonZeroIndex = 0;

        // Move non-zero elements to the beginning of the array
        for (int num : arr) {
            if (num != 0) {
                arr[nonZeroIndex++] = num;
            }
        }

        // Fill the remaining elements with zeros
        while (nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }
}

