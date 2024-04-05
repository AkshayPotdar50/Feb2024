package dsa.sorting.pract;

public class BubbleSort {

    public static void printArray(int [] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {


        int[] arr ={7,5,8,9,2,1,8};

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] >arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        printArray(arr);
    }
}
