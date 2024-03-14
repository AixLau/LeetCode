package com.string;

import java.util.Scanner;

public class kama_55 {
    /**
     * 先将整个字符反转
     * 然后在将0-k反转
     * k到s.length()反转
     */
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        // int k = sc.nextInt();
        // String s1 = s.substring(s.length() -k) + s.substring(0, s.length() - k);
        // System.out.println(s1);
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverse(chars, 0, k-1);
        reverse(chars, k, s.length() - 1);
        System.out.println(chars);
    }


    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];
            start++;
            end--;
        }
    }
}
