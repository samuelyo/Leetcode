package com.leetcode.ArrayOfDoubledPairs;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs2 {
    public static void main(String[] args) {
        int[] A = {2, 1, 2, 6};
        boolean res = canReorderDoubled(A);
        System.out.println(res);
    }

    public static boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> pos = new TreeMap<>(), neg = new TreeMap<>();
        for (int a : A) {
            if (a < 0)
                neg.put(a, neg.getOrDefault(a, 0) + 1);
            else
                pos.put(a, pos.getOrDefault(a, 0) + 1);
        }
        for (int x : pos.keySet()) {
            if (pos.get(x) > 0) {
                if (pos.get(x) > pos.getOrDefault(2 * x, 0))
                    return false;
                pos.put(2 * x, pos.get(2 * x) - pos.get(x));
            }
        }
        for (int x : neg.keySet()) {
            if (neg.get(x) > 0) {
                if (x % 2 == 1) return false;
                if (neg.get(x) > neg.getOrDefault(x / 2, 0)) return false;
                neg.put(x / 2, neg.get(x / 2) - neg.get(x));
            }
        }
        return true;
    }
}
