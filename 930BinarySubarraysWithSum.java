package com.leetcode.BinarySubarraysWithSum;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] A = {1, 0, 1, 0, 1};
        int S = 2;
        System.out.println(numSubarraysWithSum(A, S));
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> c = new HashMap<>();
        c.put(0, 1);
        int psum = 0, res = 0;
        for (int i : A) {
            psum += i;
            res += c.getOrDefault(psum - S, 0);
            c.put(psum, c.getOrDefault(psum, 0) + 1);
        }
        return res;
    }
}
