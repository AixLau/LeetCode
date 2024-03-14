package com.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNumber(n);
        }

        return n == 1;
    }

    public int getNumber(int n) {
        int res =0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        _202 v = new _202();
        boolean happy = v.isHappy(20);
    }
}
