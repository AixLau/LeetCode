package com.hashtable;

import java.util.*;

public class _49 {
    /**
     * 使用排序法解题
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将str转为char数组排序后转为string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String st = new String(chars);
            // 从这个key中拿到异位词列表，如果没有就创建一个新的
            List<String> list = map.getOrDefault(st, new ArrayList<>());
            // 将当前的异位词存入列表中，再塞回map当中
            list.add(str);
            map.put(st, list);
        }

        return new ArrayList<>(map.values());
    }
}

