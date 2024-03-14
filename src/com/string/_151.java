package com.string;

import java.util.concurrent.BrokenBarrierException;

public class _151 {

    /**
     * 使用 String.split() 方法按照空格来切割单词，用双指针来替换位置
     */
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        for (int i = 0, j = split.length - 1; i < j; i++, j--) {
            String temp = split[i];
            split[i] = split[j];
            split[j] = temp;
        }
        return String.join(" ", split);
    }

    /**
     * 使用新的数组填充
     * 从字符串末尾向左遍历字符
     * 当前位置不为空格，则记录当前位置为right，否则就向左边滑动，直到遇到字符，记录字符的位置
     * 在向左移动left，当遇到了空格，说明left+1～right 为单词
     * 通过取下标的方式填入到新的数组当中
     */
    public String reverseWords3(String s) {
        char[] initChars = s.toCharArray();
        char[] newChars = new char[s.length() + 1];
        int index =0;
        int left = s.length()-1;
        while (left >= 0) {
            while (left>=0 && initChars[left] == ' ') left--;
            int right = left;
            while (left>=0 &&initChars[left] != ' ') left--;
            for (int i = left+1; i <= right; i++) {
                newChars[index++] = initChars[i];
                if (i == right) {
                    newChars[index++] = ' ';
                }
            }
        }
        if (index == 0) {
            return "";
        } else {
            return new String(newChars, 0, index - 1);
        }
    }

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单
     */
    public String reverseWords2(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachChar(sb);
        return new String(sb);
    }

    private void reverseEachChar(StringBuilder sb) {
        int start = 0, end = 1;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = ++end;
        }
    }


    public void reverseString(StringBuilder sb, int start, int end) {
        if (sb.length() == 1) {
            return;
        }
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    public StringBuilder removeSpace(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        // while (s.charAt(start) == ' ' || s.charAt(end) == ' ') {
        //     if (s.charAt(start) == ' ') {
        //         start++;
        //     }
        //     if (s.charAt(end) == ' ') {
        //         end--;
        //     }
        // }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            // 如果这个字符不是空格直接插入，
            // 如果这是空格，但是字符串里没空格则添加空格，做到单词只间隔1个空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') sb.append(s.charAt(i));
        }
        return sb;
    }
}
