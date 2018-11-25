package com.leetcode.BagOfTokens;

import java.util.Arrays;

public class BagOfTokens2 {
    public static void main(String[] args) {
        int[] tokens = {77, 55, 82};
        int P = 54;
        int res = bagOfTokensScore(tokens, P);
        System.out.println(res);

    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int res = 0, points = 0, i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                break;
            }
        }
        return res;
    }
}
