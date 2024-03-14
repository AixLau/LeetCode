package com.array;

import com._704;

import javax.sound.midi.MidiChannel;

public class _35 {
    public int searchInsert(int[] nums, int target) {
        int p1 = 0, p2 = nums.length - 1, middle = 0;
        while (p1 <= p2) {
            middle = (p2 + p1) >> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                p2 = middle - 1;
            } else if (nums[middle] < target) {
                p1 = middle + 1;
            }
        }
        if (nums[middle] > target) {
            return middle ;
        } else {
            return middle + 1;
        }
    }
    public static void main(String[] args) {
        System.out.println("new _35().search(new int[]{-1, 0, 3, 5, 9, 12}, 9) = "
                + new _35().searchInsert(new int[]{1,3,5,6}, 1));
    }
}
