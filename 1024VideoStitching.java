package com.leetcode.VideoStitching;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int T = 10;
        int res = videoStitching(clips, T);
        System.out.println(res);
    }

    public static int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int count = 0;
        int curend = 0;
        int laststart = -1;
        for (int i = 0; i < clips.length; ) {
            if (clips[i][0] > curend) {
                return -1;
            }
            int maxend = curend;
            while (i < clips.length && clips[i][0] <= curend) { // while one clip's start is before or equal to current end
                maxend = Math.max(maxend, clips[i][1]); // find out the one with the max possible end
                i++;
            }
            count++;
            curend = maxend;
            if (curend >= T) {
                return count;
            }
        }
        return -1;
    }
}
