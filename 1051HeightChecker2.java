package com.leetcode.HeightChecker;

import java.util.Arrays;

public class HeightChecker2 {
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        int res = heightChecker(heights);
        System.out.println(res);
    }

    public static int heightChecker(int[] heights) {
        int[] h = heights.clone();
        Arrays.sort(h);
        int ans = 0;
        for (int i = 0; i < h.length; ++i) {
            if (h[i] != heights[i]) ++ans;
        }
        return ans;
    }
}
