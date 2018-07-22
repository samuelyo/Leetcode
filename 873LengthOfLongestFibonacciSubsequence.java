package com.leetcode.LengthOfLongestFibonacciSubsequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        int[] A = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(lenLongestFibSubseq(A));

    }

    public static int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : A) {
            set.add(num);
        }
        int[] res = new int[1];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                List<Integer> list = new ArrayList<>();
                if (!set.contains(A[i] + A[j])) {
                    continue;
                }
                list.add(A[i]);
                list.add(A[j]);
                helper(A, j + 1, list, res);
            }
        }
        return res[0];
    }

    private static void helper(int[] A, int index, List<Integer> list, int[] res) {
        if (index >= A.length) {
            return;
        }
        for (int i = index; i < A.length; i++) {
            if (A[i] == list.get(list.size() - 1) + list.get(list.size() - 2)) {
                list.add(A[i]);
                res[0] = Math.max(res[0], list.size());
                helper(A, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
