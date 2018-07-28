package com.leetcode.RandomPointInNonoverlappingRectangles;

import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonoverlappingRectangles {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int sum = 0;
    int[][] nums;

    public RandomPointInNonoverlappingRectangles(int[][] rects) {
        nums = rects;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sum += area;
            map.put(sum, i);
        }
    }

    public int[] pick() {
        int key = map.ceilingKey(new Random().nextInt(sum) + 1);
        int index = map.get(key);
        int[] num = nums[index];
        int left = num[0];
        int bot = num[1];
        int right = num[2];
        int top = num[3];
        return new int[]{left + new Random().nextInt(right - left + 1), bot + new Random().nextInt(top - bot + 1)};
    }
}
