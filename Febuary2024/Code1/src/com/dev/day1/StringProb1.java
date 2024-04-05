package com.dev.day1;

import java.util.Arrays;
import java.util.List;

public class StringProb1 {
    public static void main(String[] args) {

        //swap two strings
        String str1= "akshay";
        String str2="ashish";

        String Generated= String.valueOf(new StringBuffer(str1).hashCode());

        str2=str1+str2;
        str2=str2.substring(0, str2.length()-str1.length());
        str1=str2.substring(str1.length());
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("******************************************");



        /*String s1 = "listen";
        String s2 = "silent";
        System.out.println(checkAnagrams(s1,s2));

        System.out.println("********************************");

        String s3 ="nayar";
        System.out.println(checkPalindrome(s3));*/

        List<String> words = Arrays.asList("hello", "world", "stream", "hlatmap");

        //using flatmap to find out distinct letters from each word
        List<String> distinctLetters =words.stream()
                .map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        //System.out.println("Distinct letters"+distinctLetters);

        List<String> startWith =words.stream().filter(word->word.startsWith("h")).toList();
        System.out.println(startWith);
    }


    public static boolean checkAnagrams(String str1, String str2){
        str1=str1.replaceAll("\\s", "");
        str2 =str2.replaceAll("\\s", "");
        return Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
    }

    public static boolean checkPalindrome(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;

    }
}
