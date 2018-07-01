package com.leetcode.ShortestSubarrayWithSumAtLeastK;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        int[] A = {2, -1, 2};
        int K = 3;
        int len = shortestSubarray(A, K);
        System.out.println(len);
    }

    public static int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] += B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[d.getFirst()] <= B[i] - K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()]) d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
}
