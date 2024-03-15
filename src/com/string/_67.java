package com.string;

public class _67 {
    /**
     * 从两个字符串的最后一位开始向前遍历，逐位计算和。
     * 如果某位的和大于 1，则保留余数，并将进位加到下一位的计算中。
     * 每次迭代中，检查 sum 是否大于 2（即是否需要进位）并更新 carry。
     * 由于字符串是尾巴开始计算的，需要返回前将其反转。
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(i--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }
}
