package com.greed;

import java.util.Arrays;

public class _135 {
    /**
     * 创建一个数组 candies 与 ratings 同等大小，初始时每个孩子分配 1 个糖果。
     * 从左到右遍历 ratings 数组，如果当前孩子的评分高于他左边的孩子，那么当前孩子比他左边的孩子获得更多的糖果。
     * 从右到左遍历 ratings 数组，如果当前孩子的评分高于他右边的孩子，并且当前孩子的糖果数不多于他右边的孩子，
     * 那么当前孩子应该比他右边孩子获得更多的糖果。
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++)
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : candies[i];
        for (int i = ratings.length - 2; i >= 0; i--)
            candies[i] = ratings[i] > ratings[i + 1] &&
                    candies[i] < candies[i + 1] + 1 ? candies[i + 1] + 1 : candies[i];
        return Arrays.stream(candies).sum();
    }
}
