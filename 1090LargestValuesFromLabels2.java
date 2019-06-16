package com.leetcode.LargestValuesFromLabels;

import java.util.*;

public class LargestValuesFromLabels2 {
    public static void main(String[] args) {
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 1, 2, 2, 3};
        int num_wanted = 3;
        int use_limited = 1;
        System.out.println(largestValsFromLabels(values, labels, num_wanted, use_limited));

    }

    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<int[]> pairs = new ArrayList<>();
        // Labels and their corresponding number of items.
        Map<Integer, Integer> limits = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            if (!limits.containsKey(labels[i])) {
                limits.put(labels[i], 0);
            }
            pairs.add(new int[]{values[i], labels[i]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int max = 0;
        pq.addAll(pairs);
        // The number of items in the set may less than num_wanted.
        for (int i = 0; i < num_wanted && !pq.isEmpty(); ) {
            int[] pair = pq.remove();
            if (limits.get(pair[1]) < use_limit) {
                max += pair[0];
                limits.put(pair[1], limits.get(pair[1]) + 1);
                i++;
            }
        }
        return max;
    }
}