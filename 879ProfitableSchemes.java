package com.leetcode.ProfitableSchemes;

public class ProfitableSchemes {
    public static void main(String[] args) {
        int G = 5;
        int P = 3;
        int[] group = {2, 2};
        int[] profit = {2, 3};
        System.out.println(profitableSchemes(G, P, group, profit));
    }

    public static int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        int res = 0, mod = 1000000007;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], p = profit[k];
            for (int i = P; i >= 0; i--)
                for (int j = G - g; j >= 0; j--)
                    dp[Math.min(i + p, P)][j + g] = (dp[Math.min(i + p, P)][j + g] + dp[i][j]) % mod;
        }
        for (int x : dp[P]) {
            res = (res + x) % mod;
        }
        return res;
    }
}
