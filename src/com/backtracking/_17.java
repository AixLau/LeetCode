package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _17 {
    String[] letterMap = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    StringBuilder s = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) return list;
        backtracking(digits, 0, list);
        return list;
    }

    public void backtracking(String digits, int index, List<String> result) {
        if (index == digits.length()) {
            result.add(s.toString());

            return;
        }

        int digit = digits.charAt(index) - '0';
        String letter = letterMap[digit];
        for (int i = 0; i < letter.length(); i++) {
            s.append(letter.charAt(i));
            backtracking(digits, index + 1, result);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
