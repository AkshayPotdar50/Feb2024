package dsa.sorting.pract;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "stream","stream");
        List<String> distinctLetters = words.stream()
                .flatMap((word)->Arrays.stream(word.split(" ")))
                .distinct()
                .toList();
        System.out.println(distinctLetters);
        System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

        List<String> wordStartsWith =words.stream()
                .filter(word->word.startsWith("h"))
                .toList();
        System.out.println(wordStartsWith);
    }
}
