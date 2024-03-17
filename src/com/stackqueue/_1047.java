package com.stackqueue;

import java.util.ArrayDeque;

public class _1047 {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++)
            if (!deque.isEmpty() && chars[i] == deque.peek()) deque.pop();
            else deque.push(chars[i]);
        if (deque.isEmpty()) return "";
        else {
            StringBuilder sb = new StringBuilder();
            return sb.toString();
        }
    }

    /**
     * 拿字符串直接作为栈，省去了栈还要转为字符串的操作
     */
    public String removeDuplicates2(String s) {
        StringBuilder res = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++)
            if (top >= 0 && s.charAt(i) == res.charAt(top)) res.deleteCharAt(top--);
            else {
                res.append(s.charAt(i));
                top++;
            }
        return res.toString();
    }

    /**
     * 使用双指针
     */
    public String removeDuplicates3(String s) {
        char[] chars = s.toCharArray();
        int fast = 0, slow = 0;
        while (fast < s.length()) {
            chars[slow] = chars[fast];
            if (slow > 0 && chars[slow] == chars[slow - 1]) slow--;
            else slow++;
            fast++;
        }
        return new String(chars, 0, slow);
    }
}
