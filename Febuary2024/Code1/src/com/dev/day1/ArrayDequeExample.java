package com.dev.day1;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Adding elements to the front and back
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerFirst(1);
        deque.offerLast(4);


        // Removing elements from the front and back
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
            System.out.println(deque.pollLast());
        }
    }
}
