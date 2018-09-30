package com.leetcode.PartitionArrayIntoDisjointIntervals;

public class PartitionArrayIntoDisjointIntervals2 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 6, 12};
        int res = partitionDisjoint(A);
        System.out.println(res);
    }

    public static int partitionDisjoint(int[] A) {
        int n = A.length, pmax = 0, B[] = new int[n];
        B[n - 1] = A[n - 1];
        for (int i = n - 2; i > 0; --i)
            B[i] = Math.min(A[i], B[i + 1]);
        for (int i = 1; i < n; ++i) {
            pmax = Math.max(pmax, A[i - 1]);
            if (pmax <= B[i]) return i;
        }
        return n;
    }
}
