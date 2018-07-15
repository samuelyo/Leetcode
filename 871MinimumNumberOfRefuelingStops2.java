package com.leetcode.MinimumNumberOfRefuelingStops;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops2 {
    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int res = minRefuelStops(target, startFuel, stations);
        System.out.println(res);
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>();
        long dist = startFuel;
        int res = 0;
        int idx = 0;
        while (true) {
            while (idx < stations.length && stations[idx][0] <= dist) {
                queue.offer(-stations[idx][1]);
                idx++;
            }

            if (dist >= target) return res;
            if (queue.isEmpty()) return -1;
            dist += -queue.poll();
            res++;
        }
    }
}
