package com.array;


import java.util.HashMap;
import java.util.Map;

public class _136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
