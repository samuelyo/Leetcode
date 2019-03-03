package com.leetcode.MaxConsecutiveOnesIII;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        int res = longestOnes(A, K);
        System.out.println(res);
    }

    public static int longestOnes(int[] A, int K) {
        int res = 0, i = 0;
        for (int j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            while (K < 0)
                if (A[i++] == 0) K++;
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
