package com.leetcode.SumOfEvenNumbersAfterQueries;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] res = sumEvenAfterQueries(A, queries);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) {
            if (a % 2 == 0) sum += a;
        } // sum of even #s.
        int[] ans = new int[queries.length];
        for (int i = 0; i < A.length; ++i) {
            int idx = queries[i][1];
            if (A[idx] % 2 == 0) {
                sum -= A[idx];
            }
            A[idx] += queries[i][0];
            if (A[idx] % 2 == 0) {
                sum += A[idx];
            }
            ans[i] = sum;
        }
        return ans;
    }
}
