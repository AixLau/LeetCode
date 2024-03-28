package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _268 {
    public int missingNumber(int[] nums) {
        return 0;
    }

    public int sortMethod(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) if (i != nums[i]) return i;
        return -1;
    }

    public int hashMethod(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) set.add(num);
        for (int i = 0; i < n; i++) if (!set.contains(i)) return i;
        return n;
    }

    /**
     * 数学：
     * 将从 0 到 n 的全部整数之和记为 total，根据高斯求和公式有 n（n+1)/2
     * 将数组 nums 的元素之和记为 sum，sum 比 total 少了丢失的一个数字，
     * 因此丢失的数字即为 total 与 sum 之差
     */
    public int numMethod(int[] nums) {
        int n = nums.length;
        int total = n * (n - 1) >> 1;
        int sum = 0;
        for (int num : nums) sum += num;
        return total - sum;
    }

    /**
     * 利用异或运算的性质 a^a=0 a^0=a
     * 首相，将变量 missing 初始化为 nums 数组的长度，
     * 因为在[0,N]范围内，可能缺失的数为 n。
     * 遍历 nums，将 missing 与数组中的每个元素以及对应的索引进行异或运算。
     * 由于异或运算的性质，相同的数异或结果为 0，因此最终 missing 是缺失的哪个数。
     */
    public int bitOperation(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) missing ^= i ^ nums[i];
        return missing;
    }
}
