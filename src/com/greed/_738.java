package com.greed;

public class _738 {
    /**
     * 将 n 转换为字符数组，便于逐位处理。
     * 从左到右遍历字符数组，比较每一位与其后一位的大小(digits[i]>digits[i+1]，则需要进行调整
     * 将 digits[i]--
     * 将当前位后的所有位设置为 9（因为要找小于或等于 n 的最大单调递减数字）
     * 同时，为了保证减一后数字仍是单调递增的，需要向前回溯，继续检查并调整。
     * 最后将调整的字符数组转换回整数。
     */
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        // mark变量用于记录需要调整的位
        int mark = digits.length;
        for (int i = digits.length - 1; i > 0; i--)
            if (digits[i] < digits[i - 1]) {
                mark = i;
                digits[i - 1]--;
            }
        for (int i = mark; i < digits.length; i++) digits[i] = '9';
        return Integer.parseInt(new String(digits));
    }
    /*
      mark变量用于记录需要调整的位。
      从后向前遍历数字的每一位，如果发现当前位大于前一位，就将前一位减1，
      并将mark更新为当前位置，表示从这里开始到数字末尾的所有位都需要设置为9。
      遍历完成后，将字符数组转换回整数，得到的就是小于或等于n的最大单调递增数字。
     */
}
