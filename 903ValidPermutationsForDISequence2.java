package com.leetcode.ValidPermutationsForDISequence;

public class ValidPermutationsForDISequence2 {
    public static void main(String[] args) {
        String S = "DID";
        int num = numPermsDISequence(S);
        System.out.println(num);
    }

    public static int numPermsDISequence(String S) {
        int N = S.length() + 1;
        char[] chs = S.toCharArray();
        int MOD = 1000000007;
        // dp[i][j] number of permutation whose length is i and end with j
        int[][] dp = new int[202][202];
        dp[1][1] = 1;
        for (int i = 2; i <= N; ++i) {
            // length is i
            for (int j = 1; j <= i; ++j) {
                // end with j
                if (chs[i - 2] == 'D') {
                    // decrease to j
                    // add all string with with i - 1 and last digit is greater than or equal to j
                    for (int k = j; k <= i; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                } else {
                    // increase to j
                    // add all string with with i - 1 and last digit is smaller than j
                    for (int k = 1; k < j; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; ++i)
            ans = (ans + dp[N][i]) % MOD;
        return ans;
    }
}
