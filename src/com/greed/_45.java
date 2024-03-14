package com.greed;

public class _45 {
    public int jump(int[] nums) {
        /*
           jumps：记录到达末尾所需的最小跳跃次数
           curFarthest：在当前所有可选跳跃中，能达到的最远距离
           curEnd：当前跳跃能到的最远距离
         */
        int jumps = 0, curFarthest = 0, curEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (curFarthest >= nums.length - 1) return ++jumps;
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
