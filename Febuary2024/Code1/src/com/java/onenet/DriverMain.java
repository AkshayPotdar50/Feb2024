package com.java.onenet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverMain {
    public static void main(String[] args) {
        List<Employee> list1 = new ArrayList<Employee>();
        Employee e1 =new Employee("abc", 25, 12000);
        Employee e2 =new Employee("def", 27, 12000);
        Employee e3 =new Employee("ghi", 32, 12000);
        Employee e4 =new Employee("ijk", 21, 12000);
        Employee e5 =new Employee("lmn", 27, 12000);

        list1.add(e1);
        list1.add(e2);
        list1.add(e3);
        list1.add(e4);
        list1.add(e5);

        //increase salary by 10% of employee whoes age is greater than 25

          List<Employee> list2 = list1.stream().map(e->{
            if(e.getAge() > 25){
                e.setSalary(e.getSalary()*1.10);
            }
            return e;
        }).toList();
        System.out.println(list2);

    }
}
