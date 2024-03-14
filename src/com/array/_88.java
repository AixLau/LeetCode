package com.array;

import java.util.Arrays;

public class _88 {

    /**
     * 采用双指针比大小的方法排序放入一个新的数组中，在for回原数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sortNums = new int[nums1.length];
        int p1 = 0, p2 = 0;
        int i = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                sortNums[i++] = nums1[p1++];
            } else {
                sortNums[i++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            sortNums[i++] = nums1[p1++];
        }
        while (p2 < n) {
            sortNums[i++] = nums2[p2++];
        }
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = sortNums[j];
        }

    }

    /**
     * 在不额外使用数组的情况下，用双指针
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 定义两个指针，指向数组的尾巴
        int p1 = m - 1, p2 = n - 1;
        // 定义一个当前指针用来存储需要插入的元素
        // 定义一个尾巴指针指向数组最后的位置
        int cur, tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            // 当nums1数组没有元素比较时，直接将nums2的数组插入进去
            if (p1 == -1) {
                cur = nums2[p2--];
                // 当nums2数组没元素时，直接将nums1的数组元素插入
            } else if (p2 == -1) {
                cur = nums1[p1--];
                // 当 nums1的元素大于nums2的元素时，这时将numbs的元素插入
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1, 5, 6};

        new _88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
