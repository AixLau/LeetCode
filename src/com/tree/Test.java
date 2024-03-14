package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ans.add(list);
        System.out.println(ans);
        list.remove(list.size() - 1);
        System.out.println(ans);
    }
}
