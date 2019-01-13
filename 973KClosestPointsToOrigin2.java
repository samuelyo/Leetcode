package com.leetcode.KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin2 {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        int[][] res = kClosest(points, K);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
