package com.leetcode.SquaresOfASortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaresOfASortedArray2 {
    public static void main(String[] args) {
        int[] A = {-7, -3, 2, 3, 11};
        int[] res = sortedSquares(A);
        System.out.println(Arrays.toString(res));

    }

    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
