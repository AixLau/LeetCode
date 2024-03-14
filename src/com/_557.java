package com;

import jdk.jfr.internal.tool.Main;

public class _557 {
    public String reverseWords(String s) {
        String[] strings = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            for (int j = string.length()-1; j >=0; j--) {
                sb.append(string.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
