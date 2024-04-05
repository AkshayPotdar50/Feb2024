package bold.thread;

import java.util.Arrays;

public class LargestNumber {
    //form the largest number using elements of array
    public static void main(String[] args) {
        String[] arr1 = {"99", "21", "72", "78", "43"};
        System.out.println(formLargestNumber(arr1));

        String s= "akshay";
        System.out.println("******************************");


        System.out.println(findFirstNonRepeating(s));


    }

    public static String formLargestNumber(String[] arr){
        Arrays.sort(arr, (num1, num2)->(num1 + num2).compareTo(num2+ num1));

        StringBuilder str = new StringBuilder();
        for(String s: arr){
            str.append(s);
        }
        return str.toString();

    }

    public static int findFirstNonRepeating(String s){
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(s.indexOf(c) ==s.lastIndexOf(c)){
                return i;
            }
        }
        return -1;
    }
}
