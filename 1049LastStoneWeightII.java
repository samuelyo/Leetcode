package com.leetcode.LastStoneWeightII;

public class LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int res = lastStoneWeightII(stones);
        System.out.println(res);
    }

    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int ele : stones) {
            sum += ele;
        }
        int total_sum = sum;
        int n = stones.length;
        sum /= 2;
        boolean[][] dp = new boolean[sum + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }
        int max = 0;
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= stones.length; j++) {
                if (dp[i][j - 1] == true || (i >= stones[j - 1] && dp[i - stones[j - 1]][j - 1])) {
                    dp[i][j] = true;
                    max = Math.max(i, max);
                }
            }
        }
        return total_sum - max * 2;
    }
}
