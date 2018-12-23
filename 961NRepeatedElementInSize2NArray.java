package com.leetcode.NRepeatedElementInSize2NArray;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {
    public static void main(String[] args) {
        int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
        int res = repeatedNTimes(A);
        System.out.println(res);

    }

    public static int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) == A.length / 2) {
                    res = num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }
}
