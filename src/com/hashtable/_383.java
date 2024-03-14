package com.hashtable;

import java.util.HashMap;

public class _383 {

    /**
     * 使用数组
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i)-'a']++;
        }
        int cnt=0;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (hash[ransomNote.charAt(i)-'a'] > 0) {
                cnt++;
                hash[ransomNote.charAt(i)]--;
            }
        }
        return cnt==ransomNote.length();
    }

    /**
     * 使用 HashMap
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt =0;
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c) &&map.get(c) > 0) {
                cnt++;
                Integer count = map.get(c) -1;
                map.put(c, count);
            }
        }
        return cnt==ransomNote.length();
    }
}
