package com.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _349 {
    /**
     * 使用 HashSet
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0,j=0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        /*
        方法1：将结果集合转为数组
        return  resSet.stream().mapToInt(x -> x).toArray();
         */
        // 方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }

        return arr;
    }

    /**
     * 使用数组
     */
    public int[] intersection2(int[] nums1, int[] nums2){
        int[] hash1= new int[1000];
        for (int i : nums1) {
            hash1[i]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (hash1[i] > 0) {
                list.add(i);
                hash1[i] =0;
            }
        }
        int index =0;
        int res[] = new int[list.size()];
        for(int i : list)
            res[index++] = i;
        return res;
    }
}
