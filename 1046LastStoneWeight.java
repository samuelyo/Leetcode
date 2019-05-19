package com.leetcode.LastStoneWeight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int res = lastStoneWeight(stones);
        System.out.println(res);
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int max1 = queue.poll();
            int max2 = queue.poll();
            if (max1 - max2 > 0) {
                queue.offer(max1 - max2);
            }
        }
        if (queue.size() == 0) {
            return 0;
        } else {
            return queue.peek();
        }
    }
}
