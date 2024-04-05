package dsa.sorting.pract;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr ={7, 8, 1, 3, 2, 4};

        for(int i=1; i<arr.length; i++){
            int current =arr[i];
            int j=i-1;
            while(j >= 0 && arr[j]>current){
                //keep swapping
                arr[j+1] =arr[j];
                j--;
            }
        }
    }
}
