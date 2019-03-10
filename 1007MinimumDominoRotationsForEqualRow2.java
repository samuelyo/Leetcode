package com.leetcode.MinimumDominoRotationsForEqualRow;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumDominoRotationsForEqualRow2 {
    public static void main(String[] args) {
        int[] A = {2, 1, 2, 4, 2, 2}, B = {5, 2, 6, 2, 3, 2};
        System.out.println(minDominoRotations(A, B));
    }

    public static int minDominoRotations(int[] A, int[] B) {
        HashSet<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] countA = new int[7], countB = new int[7];
        for (int i = 0; i < A.length; ++i) {
            s.retainAll(new HashSet<>(Arrays.asList(A[i], B[i])));
            countA[A[i]]++;
            countB[B[i]]++;
        }
        for (int i : s) return Math.min(A.length - countA[i], B.length - countB[i]);
        return -1;
    }
}
