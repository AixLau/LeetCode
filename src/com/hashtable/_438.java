package com.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] hashs = new int[26];
        int[] hashp = new int[26];

        for (int i = 0; i < p.length(); i++) {
            hashs[s.charAt(i)-'a']++;
            hashp[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(hashs, hashp)) {
            ans.add(0);
        }
        for (int i = 0; i < s.length()-p.length(); i++) {
            hashs[s.charAt(i)-'a']--;
            hashs[s.charAt(i+p.length())-'a']++;
            if (Arrays.equals(hashs, hashp)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
