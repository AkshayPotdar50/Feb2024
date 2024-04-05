package com.java.onenet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

    public static void moveZerosToStart(int [] arr){
        int nonZeroIndex=arr.length-1;
        for(int i=arr.length-1; i>=0;i--){
            if(arr[i]!=0){
                arr[nonZeroIndex--]=i;
            }
        }
        while(nonZeroIndex>0){
            arr[nonZeroIndex--]=0;
        }
    }
    public static void main(String[] args) {


        List<Student> students = new ArrayList<>();
        students.add(new Student("akshay", 22));
        students.add(new Student("bob", 20));
        students.add(new Student("charlie", 25));

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
        int [] arr1 ={0, 1, 5, 0, 8, 6, 0, 4, 0, 7};
        moveZerosToStart(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
