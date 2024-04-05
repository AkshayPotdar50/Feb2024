package com.java.onenet;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {

        String str1= "akshay";
        System.out.println("swap two strings");
        String str2 ="ashish";
        str2=str1+str2;
        str1=str2.substring(str1.length());
        str2=str2.substring(0, str2.length()-str1.length());
        System.out.println(str2 +" "+str1);
        System.out.println("*****************************");

        System.out.println("check string is palindrome or not");
      String str3 ="nayar";

        System.out.println(checkPalindrome(str3));
        System.out.println("*************************************");

        System.out.println("check anagram");
        System.out.println(checkAnagrams(str1, str2));
        System.out.println("*******************************************");

        //reverse the whole sentense
        String str4 ="akshay is bad programmer";
        String str5=new StringBuilder(str4).reverse().toString();
        System.out.println(str5);

        //reverse just words in string
        String[] words=str4.split("\\s");
        StringBuilder reversed= new StringBuilder();


        for(int i= words.length-1; i>=0; i--){
            reversed.append(words[i]);
            if(i !=0){
                reversed.append(" ");
            }
        }
        System.out.println(reversed);
        System.out.println("********************************");

        System.out.println("words count");
        long count = str4.split("\\s").length;
        System.out.println(count);
        System.out.println("***********************************************");

        System.out.println("vowel count");
        long vowelCount =str4.chars()
                .filter(c->"aeiou".contains(String.valueOf((char)c)))
                .distinct()
                .count();
        System.out.println(vowelCount);

        System.out.println("****************************************************");














    }

    public static boolean checkPalindrome(String str){
        for(int i=0; i<str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAnagrams(String str1, String str2){
        char[] charArray1 =str1.replaceAll("\\s", " ").toCharArray();
        char[] charArray2 =str2.replaceAll("\\s", " ").toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
