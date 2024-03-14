package com.array;

import java.util.Arrays;

public class _66 {
    public int[] plusOne(int[] digits) {
        int tail = digits.length - 1;
        while (tail >= 0 && digits[tail] == 9) {
            digits[tail] = 0;
            tail--;
        }

        if (tail == -1) {
            int[] ints = new int[digits.length+1];
            ints[0] = 1;
            return ints;
        } else {
            digits[tail]++;
            return digits;
        }
    }

    public static void main(String[] args) {
        _66 v = new _66();
        System.out.println(Arrays.toString(v.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
    }
}
