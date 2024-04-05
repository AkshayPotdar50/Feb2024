package com.example;

public class BinerySuccesser {
    public BinerySuccesser() {
    }

    public static Integer findSuccesser(int[] arr, int target){
        int left =0;
        int right =arr.length-1;
        Integer succesor= null;

        while(left <= right){
            int mid= left +(right -left)/2;
            if(arr[mid] ==target){
                if(mid < arr.length -1){
                    succesor = arr[mid +1];
                }
                break;
            }
            if(arr[mid] <target){
                left =mid +1;
            }else{
                succesor =arr[mid];
                right =mid -1;
            }
        }
        return succesor;
    }

    public static void main(String[] args) {
        int [] arr1 ={1, 2, 7, 6, 9, 8, 4, 3};
        int target =2;
        System.out.println(findSuccesser(arr1,target));
    }
}
