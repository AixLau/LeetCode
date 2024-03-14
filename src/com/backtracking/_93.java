package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _93 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    private void backtracking(String s, int start, int count) {
        if (count == 4 || start == s.length()) if (count == 4 && start == s.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(start) == '0') break;
            String part = s.substring(start, i + 1);
            int value = Integer.parseInt(part);
            if (value > 255) break;
            int len = sb.length();
            if (count > 0) sb.append(".");
            sb.append(value);
            backtracking(s, i + 1, count + 1);
            sb.setLength(len);
        }
    }

    private void back(String s, int start, int count) {
        if (count == 4) {
            if (start == s.length()) result.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i - start > 2) break;
            if (i > start && s.charAt(start) == '0') break;
            String part = s.substring(start, i + 1);
            int num = Integer.parseInt(part);
            if (num > 255) break;
            sb.append(part).append(".");
            back(s, i + 1, count + 1);
            sb.delete(sb.length() - part.length() - 1, sb.length());
        }
    }


    public static void main(String[] args) {
        String s = "000";
        _93 v = new _93();
        v.restoreIpAddresses(s);
        System.out.println(v.result);

    }
}
