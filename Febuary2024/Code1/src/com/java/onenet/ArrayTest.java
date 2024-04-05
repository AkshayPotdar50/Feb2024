package com.java.onenet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayTest {
    public static void main(String[] args) {
        int[] numbers ={10, 20, 10, 23, 54, 74, 12};

        //average
        double average = Arrays.stream(numbers).average().orElse(0.0);
        System.out.println(average);

        System.out.println("*///////////////*////////////*////////");

        int secondLargest = Arrays.stream(numbers)
                .distinct()
                .boxed()
                .sorted((a,b)->b-a)
                .skip(1L)
                .findFirst()
                .orElse(-1);
        System.out.println(secondLargest);
        System.out.println("*////////////////*/////////////*/////////*////");

        int secondMinimum =Arrays.stream(numbers)
                .boxed()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println(secondMinimum);
        System.out.println("*//////////*//////////*////////*/////////*/////////");

        Set<Integer> set2=  Arrays.stream(numbers)
                .distinct()
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set2);
        System.out.println("**/////////////**///////////**///////////////**////////");

        int[] arr1 ={1, 0, 3, 0, 4, 0, 5, 6, 0};
        moveZerosToStart(arr1);
        for(int num:arr1){
            System.out.print(num +" ");
        }
        System.out.println("**////////////**/////////////**////////////**////////////");

       moveZerosToEnd(arr1);
       for(int num:arr1){
       System.out.println(num +" ");
           System.out.println("***/////////**/////////**/////////**//////**/");

           Set<Integer> intersectionSet = Arrays.stream(numbers)
                   .boxed()
                   .collect(Collectors.toSet());

           Set<Integer> intersection = Arrays.stream(arr1)
                   .boxed() // Box the primitive ints
                   .filter(intersectionSet::contains)
                   .collect(Collectors.toSet());

           System.out.println(intersection);

           System.out.println("/***********////////**********////////*********");
     }
}


    private static void moveZerosToStart(int[] arr) {
        int nonZeroIndex = arr.length - 1;

        // Iterate through the array from the end and move non-zero elements to the end
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[nonZeroIndex--] = arr[i];
            }
        }

        // Fill the beginning of the array with zeros
        while (nonZeroIndex >= 0) {
            arr[nonZeroIndex--] = 0;
        }
    }


    private static void moveZerosToEnd(int [] arr){
        int nonZeroIndex=0;
        for(int num:arr){
            if(num != 0){
                arr[nonZeroIndex ++]=num;
            }
        }
        while(nonZeroIndex <arr.length){
            arr[nonZeroIndex ++]=0;
        }
    }

}
