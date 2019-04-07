package com.leetcode.VideoStitching;

import java.util.Arrays;

public class VideoStitching3 {
    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int T = 10;
        int res = videoStitching(clips, T);
        System.out.println(res);
    }

    public static int videoStitching(int[][] clips, int T) {
        int max = -1;
        for (int[] clip : clips) {
            max = Math.max(max, clip[1]);
        }
        if (max < T) return -1;
        Arrays.sort(clips, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        if (clips[0][0] != 0) return -1;
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int[] now : clips) {
            if (now[0] == 0) {
                for (int i = 0; i <= Math.min(T, now[1]); ++i) {
                    dp[i] = 1;
                }
            } else {
                if (now[0] > T) continue;
                if (dp[now[0]] == Integer.MAX_VALUE) return -1;
                int before = dp[now[0]];
                for (int i = now[0] + 1; i <= Math.min(T, now[1]); ++i) {
                    dp[i] = Math.min(dp[i], 1 + before);
                }
            }
        }
        return dp[T];
    }
}
