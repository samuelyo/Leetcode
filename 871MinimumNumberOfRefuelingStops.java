package com.leetcode.MinimumNumberOfRefuelingStops;

public class MinimumNumberOfRefuelingStops {
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int res = minRefuelStops(target, startFuel, stations);
        System.out.println(res);
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; ++i)
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; --t)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
        for (int t = 0; t <= stations.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
}
