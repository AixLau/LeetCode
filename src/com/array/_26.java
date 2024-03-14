package com.array;

import java.util.HashSet;
import java.util.Set;

public class _26 {
    /**
     * 使用双指针+ set 方法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        Set<Integer> set = new HashSet<>();
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            // 将数组中的元素都都放入 set 中用来查看是否包含该元素
            if (!set.contains(nums[fastIndex])) {
                set.add(nums[fastIndex]);
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 优化代码 使用当前指针指向的元素与前一个元素对比,来判断是否为重复元素
     * 因为题目给定的是一个严格按照递增排列的数组 所以是一个有序的数组
     * 例如[0,0,1,1,2]
     * 当两个指针同时运行到第二个元素 0 时, fast 指针发现与前一个指针元素相同
     * slow 指针就不动,找到了需要覆盖的元素,fast 指针向前移动,这时 fast 指向元素 1 与 前一个元素 0 不同
     * 这时用 fast 指向的 1 覆盖掉 slow 指向的 0 这时数组变为[0,1,1,1],然后将 slow指针向前移动指向第二个 1
     * fast 这时的指针指向了第三个 1,发现前一个元素也是 1 这时 fast 指针再向前移动,这时指向了2,
     * 再用 2 覆盖掉指向第二个 1 的 slow ,这时 fast 指针走完了,数组就变为[0,1,2,1]
     * slow 这时指向 最后一个 1,返回 slow 也就是去掉重复后的数组长度 3
     */
    public int removeDuplicates2(int[] nums) {
        // 定义一个慢指针 用来覆盖重复元素
        int slowIndex = 1;
        for (int fastIndex = 1; fastIndex <nums.length; fastIndex++) {
            // 判断 当前元素和前一个元素是否重复
            if (nums[fastIndex] != nums[fastIndex - 1]) {
                // 如果不重复就用快指针指向的元素覆盖掉慢指针指向的元素
                nums[slowIndex] = nums[fastIndex];
                // 将慢指针 向前移动
                slowIndex++;

            }
        }
        return slowIndex;
    }
}
