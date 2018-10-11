package com.leetcode.KthLargestElementInAStream;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    int cap;

    public KthLargest(int k, int[] nums) {
        cap = k;
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > cap) {
            queue.poll();
        }
        return queue.peek();
    }
}
