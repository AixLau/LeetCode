package com.string;

public class _541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        // 1.每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < chars.length; i += 2 * k) {
            // 2.剩余字符小于 2k 但大于或等于 k 个 则反转k个字符
            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(chars, i, chars.length-1);
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }
}
