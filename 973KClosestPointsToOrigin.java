package com.leetcode.KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        int[][] res = kClosest(points, K);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> queue = new PriorityQueue<>(K, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x * o1.x + o1.y * o1.y - o2.x * o2.x - o2.y * o2.y;
            }
        });
        for (int i = 0; i < points.length; i++) {
            queue.offer(new Point(points[i][0], points[i][1]));
        }
        int[][] res = new int[K][2];
        int index = 0;
        while (K > 0) {
            Point cur = queue.poll();
            res[index][0] = cur.x;
            res[index][1] = cur.y;
            index++;
            K--;
        }
        return res;
    }
}
