package com.leetcode.BagOfTokens;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] tokens = {77, 55, 82};
        int P = 54;
        int res = bagOfTokensScore(tokens, P);
        System.out.println(res);

    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int res = 0;
        int count = 0;
        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left];
                left++;
                count++;
                res = Math.max(res, count);
            } else {
                if (count > 0) {
                    P += tokens[right];
                    right--;
                    count--;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
