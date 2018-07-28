package com.leetcode.RandomPickWithWeight;

import java.util.Random;

public class RandomPickWithWeight2 {
    int[] sum;

    public RandomPickWithWeight2(int[] w) {
        int s = 0;
        sum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            s += w[i];
            sum[i] = s;
        }
    }

    public int pickIndex() {
        int num = new Random().nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (sum[mid] == num) {
                return mid;
            } else if (sum[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
