package com.dev.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HelloDevil {
    public static void main(String[] args) {
       String s1 = "akshay";
      Map<Character, Long> count = s1.chars()
              .mapToObj(c->(char)c)
              .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        System.out.println(count);

        //reverse the each word in string

        String input1 ="my name is akshay";
        String reversed = Arrays.stream(input1.split(" "))
                .map(word-> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reversed);

        //reverse the sentense

        String [] words = input1.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i=words.length-1; i>=0; i--){
            result.append(words[i]).append(" ");

        }
        String reverse=result.toString().trim();
        System.out.println(reverse);


        //find third largest number in array

        int[] array1 ={1, 99, 4, 6, 10, 100, 101, 5, 77, 66};
        int ThirdLargest=Arrays.stream(array1).distinct().boxed().sorted((a,b) -> b - a)
                .skip(2).findFirst().orElse(-1);
        System.out.println(ThirdLargest);

       List<Integer> list = new ArrayList<>();
        list.add(20);
        List<String> list2 = new LinkedList<>();
        list2.add("akshay");
        List<String>  list3 = new Vector<>();
        list3.add("akshay");
        Thread thread = new Thread(()->{
            for(int i=0; i<100; i++){
                if(list.contains(20)){
                    list.remove(1);
                }
                System.out.println(list);
            }
        });
        thread.start();


        Queue<Integer> que1 = new ArrayDeque<>();
        que1.add(20);
        que1.remove(20);
       Boolean a= que1.isEmpty();
        System.out.println(a);

        Thread thread1 = new Thread(()->{
            que1.add(20);
            System.out.println(que1);
            Thread thread2 = new Thread(()->{
                que1.remove(20);


            });
            thread2.start();
            System.out.println(que1);
        });
        thread1.start();
        System.out.println(que1);


        Set<Integer> set1 = new HashSet<>();

        Set<String> set2 = new LinkedHashSet<>();
        Set<Long> set3 = new TreeSet<>();
        set3.add(200L);
        set3.add(100L);
        set3.add(320L);
        System.out.println(set3);




        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Long> map2 = new LinkedHashMap<>();
        Map<Integer, Long> map3 = new TreeMap<>();



        //try with resources

        try(FileReader fileReader = new FileReader("example.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader)){

            String line;
            while((line =bufferedReader.readLine()) !=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }












    }
}
