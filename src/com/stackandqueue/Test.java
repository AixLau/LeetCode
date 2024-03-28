package com.stackandqueue;


import java.util.ArrayDeque;

public class Test {
    public static void main(String[] args) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        deque.push('a');
        deque.push('b');
        deque.push('c');
        System.out.println(deque);
        System.out.println(deque.poll());
    }
}
