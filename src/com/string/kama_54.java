package com.string;

import com.sun.xml.internal.ws.util.StringUtils;

public class kama_54 {
    public String swapNumber(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append("number");
            } else {
                sb.append(c);
            }
        }
        return new String(sb);
    }
}
