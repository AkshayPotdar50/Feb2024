package dsa.sorting.pract;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {


    public static void main(String[] args) {
        List<Author> list = Arrays
                .asList(new Author("akshay", 27, "java undef"),
                        new Author("ashish", 52, "biology"),
                        new Author("swapnil", 51, "physics"));
      List<String>  result= list.stream().filter(author -> author.getAge() >=50).distinct().map(Author::getBookName).map(String::toUpperCase).toList();
        System.out.println(result);
    }

}
