package com.leetcode.VideoStitching;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching2 {
    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int T = 10;
        int res = videoStitching(clips, T);
        System.out.println(res);
    }

    public static int videoStitching(int[][] clips, int T) {
        int[] dic = new int[T + 1];
        Arrays.fill(dic, -1);
        for (int j = 0; j < clips.length; j++) {
            for (int i = clips[j][0]; i <= Math.min(T, clips[j][1]); i++) dic[i] = Math.max(dic[i], clips[j][1]);
        }
        for (int i = 0; i <= T; i++) {
            if (dic[i] == -1) return -1;
        }
        int cur = 0;
        int ans = 0;
        int max = 0;
        while (max < T) {
            max = dic[cur];
            ans++;
            cur = max;
        }
        return ans;
    }
}
