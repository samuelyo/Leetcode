package com.leetcode.DIStringMatch;

import java.util.Arrays;

public class DIStringMatch {
    public static void main(String[] args) {
        String S = "IDID";
        int[] res = diStringMatch(S);
        System.out.println(Arrays.toString(res));
    }

    public static int[] diStringMatch(String S) {
        if (S == null || S.length() == 0) {
            return new int[0];
        }
        int[] res = new int[S.length() + 1];
        int left = 0;
        int right = S.length();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur == 'I') {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
        }
        res[S.length()] = left;
        return res;
    }
}
