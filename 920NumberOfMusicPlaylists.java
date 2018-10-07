package com.leetcode.NumberOfMusicPlaylists;

public class NumberOfMusicPlaylists {
    public static void main(String[] args) {
        int N = 3;
        int L = 3;
        int K = 1;
        System.out.println(numMusicPlaylists(N, L, K));
    }

    public static long mod = (long) 1e9 + 7;

    public static int numMusicPlaylists(int N, int L, int K) {
        long[][] dp = new long[N + 1][L + 1];
        for (int i = K + 1; i <= N; ++i)
            for (int j = i; j <= L; ++j)
                if ((i == j) || (i == K + 1))
                    dp[i][j] = factorial(i);
                else
                    dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - K)) % mod;
        return (int) dp[N][L];
    }

    public static long factorial(int n) {
        return n > 0 ? factorial(n - 1) * n % mod : 1;
    }
}
