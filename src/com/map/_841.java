package com.map;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean v : visited) if (!v) return false;
        return true;
    }

    /***
     * 从 0 号房间开始，使用收集到的钥匙尝试访问其他房间。
     * 每访问一个房间，就标记该房间为已访问。
     * 如果所有的房间都被访问过。则返回 true，否则返回 false。
     */
    private void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {
        visited[index] = true; // 标记当前房间为已访问
        // 如果钥匙对应的房间未被访问，则访问该房间
        for (Integer key : rooms.get(index)) if (!visited[key]) dfs(rooms, key, visited);
    }

    private void bfs(List<List<Integer>> rooms, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll(); // 取出一个房间进行访问
            for (Integer key : rooms.get(index))
                if (!visited[key]) { //如果对应的房间未被访问，则将其加入队列中
                    visited[key] = true;
                    queue.offer(key);
                }
        }
    }
}
