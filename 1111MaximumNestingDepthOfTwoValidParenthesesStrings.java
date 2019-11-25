package com.leetcode.MaximumNestingDepthOfTwoValidParenthesesStrings;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public static void main(String[] args) {
        String seq = "(()())";
        int[] res = maxDepthAfterSplit(seq);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), res[] = new int[n];
        for (int i = 0; i < n; ++i)
            res[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        return res;
    }
}
