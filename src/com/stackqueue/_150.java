package com.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class _150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque();
        for (String token : tokens)
            if (token.equals("+")) deque.push(deque.pop() + deque.pop());
            else if (token.equals("-")) deque.push(-deque.pop() + deque.pop());
            else if (token.equals("*")) deque.push(deque.pop() * deque.pop());
            else if (token.equals("/")) {
                int x = deque.pop();
                int y = deque.pop();
                deque.push(y / x);
            } else deque.push(Integer.valueOf(token));
        System.out.println((deque.pop()));
        return 0;
    }

    public static void main(String[] args) {
        _150 v = new _150();
        String[] token = {"5", "1", "+", "3", "/"};
        v.evalRPN(token);

    }
}
