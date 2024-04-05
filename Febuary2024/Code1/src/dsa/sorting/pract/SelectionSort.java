package dsa.sorting.pract;

public class SelectionSort {

    public static void printArray(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {


        int[] arr={7, 8, 1, 3, 2, 4};

        for(int i=0; i<arr.length ; i++){
            int smallest =i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[smallest]){
                    smallest=j;
                }

            }
            int temp=arr[smallest];
            arr[smallest]=arr[i];
            arr[i]=temp;
        }
        printArray(arr);

    }
}
