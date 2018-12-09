package com.leetcode.ArrayOfDoubledPairs;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        int[] A = {2, 1, 2, 6};
        boolean res = canReorderDoubled(A);
        System.out.println(res);
    }

    public static boolean canReorderDoubled(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        Map<Integer, Integer> pos = new TreeMap<>();
        Map<Integer, Integer> neg = new TreeMap<>();
        for (int num : A) {
            if (num >= 0) {
                pos.put(num, pos.getOrDefault(num, 0) + 1);
            } else {
                neg.put(num, neg.getOrDefault(num, 0) + 1);
            }
        }
        for (int p : pos.keySet()) {
            if (pos.get(p) > 0) {
                if (pos.get(p) > pos.getOrDefault(p * 2, 0)) {
                    return false;
                } else {
                    pos.put(p * 2, pos.get(p * 2) - pos.get(p));
                }
            }
        }
        for (int n : neg.keySet()) {
            if (neg.get(n) > 0) {
                if (n % 2 == 1) {
                    return false;
                }
                if (neg.get(n) > neg.getOrDefault(n / 2, 0)) {
                    return false;
                } else {
                    neg.put(n / 2, neg.get(n / 2) - neg.get(n));
                }
            }
        }
        return true;
    }
}
