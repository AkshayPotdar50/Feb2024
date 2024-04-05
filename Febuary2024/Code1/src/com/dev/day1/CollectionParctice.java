package com.dev.day1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class CollectionParctice {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("akshay");

        ArrayList<String> list4 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        List<String> list3 = new Vector<>();

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new LinkedHashSet<>();
        Set<String> set3 = new TreeSet<>();

        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new LinkedHashMap<>();
        Map<Integer, String> map3 = new TreeMap<>();

        //fileInputStream

        try(FileInputStream fin = new FileInputStream("D:\\test")){
        int i = fin.read();
            System.out.println((char)i);
        }catch (Exception e){
            e.printStackTrace();
        }

        


    }
}
