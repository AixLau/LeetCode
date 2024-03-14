package com;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = nums.length-k; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int[] nums2 = new int[nums.length];
        for (int i = 0; i < k; i++) {
            nums2[i] =  queue.poll();

        }
        for (int i = 0; i < nums.length-k; i++) {
            nums2[k + i] = nums[i];
        }
        nums = nums2;
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new _189().rotate(new int[]{-1,3}, 3);
    }
}
