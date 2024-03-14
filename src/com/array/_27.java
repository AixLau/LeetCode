package com.array;

public class _27 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            // 当快指针和慢指针指向的元素非消除元素时,同时移动指针;
            // 当指针指向了消除元素时,快指针向前移动,慢指针不动;
            // 用快指针元素覆盖掉慢指针的元素,两个指针同时向前移动.
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }

        }
        return slowIndex;
    }

    public static void main(String[] args) {
        System.out.println(new _27().removeElement(new int[]{3, 2, 2, 3}, 3));
    }

}
