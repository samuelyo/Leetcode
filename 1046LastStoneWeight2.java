package com.leetcode.LastStoneWeight;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight2 {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int res = lastStoneWeight(stones);
        System.out.println(res);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones)
            pq.offer(i);
        while (pq.size() > 1) {
            int max1 = pq.poll();
            int max2 = pq.poll();
            if (max1 - max2 > 0)
                pq.offer(max1 - max2);
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }
}
