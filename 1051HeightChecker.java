package com.leetcode.HeightChecker;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        int res = heightChecker(heights);
        System.out.println(res);
    }

    public static int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }
}
