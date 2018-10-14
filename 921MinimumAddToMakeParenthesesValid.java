package com.leetcode.MinimumAddToMakeParenthesesValid;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String S = "()))((";
        System.out.println(minAddToMakeValid(S));
    }

    public static int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        char[] chs = S.toCharArray();
        int res = 0;
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    res++;
                    count++;
                }
            }
        }
        return count + res;
    }
}
