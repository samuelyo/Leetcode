package com.leetcode.MinimumAreaRectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        System.out.println(minAreaRect(points));
    }

    public static int minAreaRect(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(x, list);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                if (point1[0] == point2[0] || point1[1] == point2[1]) {
                    continue;
                }
                if (map.get(point1[0]).contains(point2[1]) && map.get(point2[0]).contains(point1[1])) {
                    res = Math.min(res, Math.abs(point1[0] - point2[0]) * Math.abs(point1[1] - point2[1]));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
