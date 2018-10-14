package com.leetcode.SortArrayByParityII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParityII2 {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        int[] res = sortArrayByParityII(A);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;

        while (even < A.length && odd < A.length) {
            while (odd < A.length && A[odd] % 2 == 1) odd += 2;
            while (even < A.length && A[even] % 2 == 0) even += 2;

            if (even < A.length && odd < A.length) {
                swap(A, even, odd);
                even += 2;
                odd += 2;
            }
        }

        return A;

    }

    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
