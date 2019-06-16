package com.leetcode.LargestValuesFromLabels;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    int value;
    int label;

    Pair(int value, int label) {
        this.value = value;
        this.label = label;
    }
}

public class LargestValuesFromLabels {
    public static void main(String[] args) {
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 1, 2, 2, 3};
        int num_wanted = 3;
        int use_limited = 1;
        System.out.println(largestValsFromLabels(values, labels, num_wanted, use_limited));

    }

    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        });
        for (int i = 0; i < values.length; i++) {
            queue.offer(new Pair(values[i], labels[i]));
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (map.getOrDefault(cur.label, 0) < use_limit) {
                count++;
                max += cur.value;
                map.put(cur.label, map.getOrDefault(cur.label, 0) + 1);
            }
            if (count >= num_wanted) {
                break;
            }
        }
        return max;
    }
}
