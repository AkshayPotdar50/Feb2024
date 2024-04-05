package com.java.onenet;

import java.util.*;

class AgeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}

public class CollectionMania {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();

        List<Integer> vect1 = new Vector<>();
        List<Integer> lINK1 = new LinkedList<>();

        Queue<Integer> Que1 = new ArrayDeque<>();
        Queue<Integer> Que2 = new PriorityQueue<>();

        HashSet<Integer> set1 = new HashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

        TreeSet<Employee> set3 = new TreeSet<>(new AgeComparator());
        Employee e1 =new Employee("abc", 25, 11000);
        Employee e2 =new Employee("def", 27, 12000);
        Employee e3 =new Employee("ghi", 32, 13000);
        Employee e4 =new Employee("ijk", 21, 14000);
        Employee e5 =new Employee("lmn", 28, 15000);

        set3.add(e1);
        set3.add(e2);
        set3.add(e3);
        set3.add(e4);
        set3.add(e5);
        for(Employee employee:set3){
            System.out.println(employee);
        }







    }
}
class OneNetwork{

    public static void main(String[] args) {
        Map<Integer, Employee> map1 = new HashMap<>();
        Map<Integer, String> map2 = new LinkedHashMap<>();
        Map<Integer, String> map3 = new TreeMap<>();

        Employee e1 =new Employee("abc", 25, 11000);
        Employee e2 =new Employee("def", 27, 12000);
        Employee e3 =new Employee("ghi", 32, 13000);
        Employee e4 =new Employee("ijk", 21, 14000);
        Employee e5 =new Employee("lmn", 28, 15000);
        map1.put(1,e1);
        map1.put(2, e2);
        map1.put(3, e3);
        map1.put(4, e4);
        map1.put(5, e5);

        for(Map.Entry<Integer, Employee> entry :map1.entrySet()){
            System.out.println(entry.getKey() +" " +entry.getValue());
        }

    }
}
