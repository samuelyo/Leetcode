package com.leetcode.PartitionArrayIntoDisjointIntervals;

public class PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 6, 12};
        int res = partitionDisjoint(A);
        System.out.println(res);
    }

    public static int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] max = new int[A.length];
        max[0] = A[0];
        int temp = A[0];
        for (int i = 1; i < A.length; i++) {
            temp = Math.max(temp, A[i]);
            max[i] = temp;
        }
        int[] min = new int[A.length];
        min[A.length - 1] = A[A.length - 1];
        temp = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            temp = Math.min(temp, A[i]);
            min[i] = temp;
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }
}
