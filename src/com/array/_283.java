package com.array;

public class _283 {
    /**
     * 解题思路依旧采用双指针的方式解题
     * 当快指针遇到 0 时,慢指针指向这个 0,快指针向前移动直到不是 0 就用该元素与 0 替换
     * 替换完之后,将慢指针向前移动
     * 如果快指针和慢指针指向的同一个元素就原地互换位置,向前移动慢指针
     * (也就是只要 fast 指向的元素不等于 0 就换位置)
     */
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int slowIndex =0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                int temporary = nums[fastIndex];
                nums[fastIndex] = nums[slowIndex];
                nums[slowIndex++] = temporary;
            }
        }
    }
}
