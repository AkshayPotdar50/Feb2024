package dsa.sorting.pract;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Streaming1 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "AAA", "BB", "BBBBB", "CC", "CCCC");

        List<String> sortedString =list.stream().sorted(Comparator.comparingInt(String::length)).toList(); //this is by using comparator
        System.out.println(sortedString);

        System.out.println("************************************");

        List<String> list1 =list.stream().sorted().toList();
        System.out.println(list1);

        List<String> list3 =list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list3);

      List<String> list4 =  list.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(list4);

        String s1 = list.stream().sorted(Comparator.reverseOrder()).skip(3).findFirst().get();
        System.out.println(s1);

        //min() will return 1 st element
        //max() will return last element







    }
}
