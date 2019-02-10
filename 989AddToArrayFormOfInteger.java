package com.leetcode.AddToArrayFormOfInteger;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        int[] A = {1, 2, 0, 0};
        int K = 34;
        List<Integer> res = addToArrayForm(A, K);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i) + " ");
        }

    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
