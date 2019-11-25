package com.leetcode.MaximumNestingDepthOfTwoValidParenthesesStrings;

public class MaximumNestingDepthOfTwoValidParenthesesStrings2 {
    public static void main(String[] args) {
        String seq = "(()())";
        int[] res = maxDepthAfterSplit(seq);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int lv = 0; // level
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                lv++;
                res[i] = lv % 2;
            } else {
                res[i] = lv % 2;
                lv--;
            }
        }
        return res;
    }
}
