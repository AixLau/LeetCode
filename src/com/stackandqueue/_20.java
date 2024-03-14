package com.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() ||ch != deque.peek()) {
                return false;
            } else {
                deque.pop();
            }
        }

        return deque.isEmpty();
    }
}
