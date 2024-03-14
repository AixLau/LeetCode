package com.array;

public class _844 {
    // public boolean backspaceCompare(String s, String t) {
    //     int i = s.length() - 1, j = t.length() - 1;
    //     int skipS = 0, skipT = 0;
    //     while (i >= 0 || j >= 0) {
    //         while (i >= 0) {
    //             // 如果当前元素为 # 那么就跳过+1 把指针往左边移动一位
    //             if (s.charAt(i) == '#') {
    //                 skipS++;
    //                 i--;
    //
    //                 // 如果当前元素的 skip 大于 0 说明需要跳过该元素
    //             } else if (skipS > 0) {
    //                 skipS--;
    //                 i--;
    //                 // 如果当前元素既不是 # 也不用跳过 那么 i 指向的元素即是需要比较的元素
    //             } else {
    //                 break;
    //             }
    //         }
    //
    //         while (j >= 0) {
    //             if (t.charAt(j) == '#') {
    //                 skipT++;
    //                 j--;
    //             } else if (skipT > 0) {
    //                 skipT--;
    //                 j--;
    //             } else {
    //
    //                 break;
    //             }
    //         }
    //         // 如果s 和 t 都指向了元素 那么就进行比较
    //         if (i >= 0 && j >= 0) {
    //             // 如果两个元素不相等 直接返回 false
    //             if (s.charAt(i) != t.charAt(j)) {
    //                 return false;
    //             }
    //             // 如果有一位越界了说明两个不相等
    //         } else {
    //             if (i >= 0 || j >= 0) {
    //                 return false;
    //             }
    //         }
    //         // 比较完之后将指针往左移动
    //         i--;
    //         j--;
    //     }
    //     return true;
    // }
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _844().backspaceCompare("bxj##tw", "bxj###tw"));
    }
}
