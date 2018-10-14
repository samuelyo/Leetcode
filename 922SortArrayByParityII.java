package com.leetcode.SortArrayByParityII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        int[] res = sortArrayByParityII(A);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int num : A) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        int[] res = new int[A.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = even.get(evenIndex);
                evenIndex++;
            } else {
                res[i] = odd.get(oddIndex);
                oddIndex++;
            }
        }
        return res;
    }
}
