package com.greed;

import java.util.Arrays;
import java.util.LinkedList;

public class _406 {
    /**
     * 按照身高 h 降序，确保按顺序插入每个人时，任何时刻插入队列都是当前未被插入的人中最高的。
     * 如果身高相同，按照 k 值升序。这样保证了对于相同身高的人，也可以按照 k 值依次插入。
     * 初始化一个空列表 queue。遍历 people，对于每个人 p，按照他的 k 值插入到 queue 的对应位置。
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p : people) queue.add(p[1], p); // 根据k值插入到指定位置
        return queue.toArray(new int[queue.size()][]);
    }
}
