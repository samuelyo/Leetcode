package com.leetcode.ValidPermutationsForDISequence;

public class ValidPermutationsForDISequence {
    public static void main(String[] args) {
        String S = "DID";
        int num = numPermsDISequence(S);
        System.out.println(num);
    }

    public static int numPermsDISequence(String S) {
        int n = S.length(), mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++)
            if (S.charAt(i) == 'I')
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % mod;
        return dp[n][0];
    }
}
