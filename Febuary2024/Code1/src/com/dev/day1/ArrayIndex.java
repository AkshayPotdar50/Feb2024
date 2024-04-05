package com.dev.day1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayIndex {
    public ArrayIndex() {
    }

    public static void main(String[] args) {
        long[] arr = new long[]{1L, 2L, 3L, 4L, 5L};
        int index = findIndex(5L, arr);
      //  System.out.println(index);

        List<String> wordin = Arrays.asList("AA","BB","AA","DD","CC","DD");

        Map<String, Long> wordsCountMap = wordin.parallelStream()
                .collect(Collectors.toConcurrentMap(Function.identity(), v -> 1L, Long::sum))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(wordsCountMap);
    }

    static int findIndex(long n, long[] arr) { // Corrected parameter type to long
        OptionalInt result = IntStream.range(0, arr.length)
                .filter(i -> arr[i] == n)
                .findFirst();

        return result.orElse(-1);
    }
}
