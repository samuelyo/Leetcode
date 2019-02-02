package com.leetcode.TriplesWithBitwiseANDEqualToZero;

import java.util.Arrays;

public class TriplesWithBitwiseANDEqualToZero2 {
    public static void main(String[] args) {
        int[] A = {2, 1, 3};
        System.out.println(countTriplets(A));
    }

    public static int countTriplets(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int tmp = A[i] & A[j];
                for (int k = j; k < A.length; k++) {
                    int re = tmp & A[k];
                    if (re == 0) {
                        if (i == j && j == k) {
                            count += 1;
                        } else if (i == j || i == k || j == k) {
                            count += 3;
                        } else {
                            count += 6;
                        }
                    }
                }
            }
        }
        return count;
    }
}
