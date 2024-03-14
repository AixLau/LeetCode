package com.hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class _242 {
    /**
     * 用两个 hashmap 存储字符串各字符出现的次数
     */
    public boolean isAnagram(String s, String t) {
        int slen = s.length(), tlen = t.length();
        HashMap<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        if (smap.size() == tmap.size()) {
            Set<Character> characters = smap.keySet();
            Iterator<Character> iterator = characters.iterator();
            while (iterator.hasNext()) {
                Character key = iterator.next();
                if (!smap.get(key).equals(tmap.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 定义一个 record 数组 记录字符串各字符出现次数
     * 把字符映射到数组的索引下标中
     * 因为字符a-z的 ASCII 是连续的数值，所以字符a映射下标为0
     * 遍历字符串s 只需要将 s[i] - ‘a’ 所在的元素做+1 操作即可
     * 同样在遍历字符串t的时候，对t中出现的字符映射哈希表索引上的数值再做-1的操作
     * 那么最后检查一下，record数组如果有的元素不为零0，
     * 说明字符串s和t一定是谁多了字符或者谁少了字符，return false
     * 最后如果record数组所有元素都为零0，说明字符串s和t是字母异位词，return true
     */
    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            record[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            record[ch - 'a']--;
        }
        for (int cnt : record) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
