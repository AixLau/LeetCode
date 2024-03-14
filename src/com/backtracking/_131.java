package com.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _131 {
    List<List<String>> result = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++)
            if (isPalindrome(s, start, i)) {
                path.addLast(s.substring(start, i + 1));
                backtracking(s, i + 1);
                path.removeLast();
            }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) if (s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }
}
