package com.stackandqueue;

import com.array._904;
import com.stackandqueue.MyQueue;
import com.stackandqueue._232;
import com.string._151;
import com.string._28;

import java.util.*;

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
