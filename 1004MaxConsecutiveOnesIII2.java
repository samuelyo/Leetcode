package com.leetcode.MaxConsecutiveOnesIII;

public class MaxConsecutiveOnesIII2 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        int res = longestOnes(A, K);
        System.out.println(res);
    }

    public static int longestOnes(int[] A, int K) {
        int zeroCount = 0, start = 0, res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zeroCount++;
            while (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
