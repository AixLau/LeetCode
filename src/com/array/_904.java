package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _904 {
    public int totalFruit(int[] fruits) {
        // 用于存储满足条件的最长子数组的长度
        int n =fruits.length, ans =0;
        // 用于记录美中果树出现的次数
        int[] cnts = new int[n];
        // 使用滑动窗口的方法，通过两个指针i和j来控制窗口的大小和位置。
        // i负责扩大窗口，j负责缩小窗口。
        // tot用于记录当前窗口中不同果树的种类数。
        for (int i = 0, j=0, tot= 0; i < n; i++) {
            // 将 x 种类的果树计数+1
            if (++cnts[fruits[i]] == 1) {
                // 如果第一次遇到 x 果树， 则种类树+1
                tot++;
            }

            // 如果窗口中的果树种类超过了2种
            // 就进入循环，通过移动j来缩小窗口，直到窗口中的果树种类不超过2种
            while (tot > 2) {
                // 将窗口左边移除的果树种类的计数减1，
                // 如果某种果树的计数变为0，表示这种果树已经完全从窗口中移除了
                // 因此种类树减1
                if (--cnts[fruits[j++]] == 0) {
                    tot--;
                }
            }
            // 每次循环结束时，都会计算当前窗口的大小
            // 并更新 ans 为当前窗口大小和之前记录的 ans 中的较大值
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        _904 v = new _904();
        int[] nums = {1, 2, 3, 2, 2};
        int[] nums1 = {0, 1, 2, 2};
        int[] nums2 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int i = v.totalFruit(nums2);
        System.out.println(i);
    }
}
