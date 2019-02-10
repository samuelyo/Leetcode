package com.leetcode.SubarraysWithKDifferentIntegers;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2};
        int K = 2;
        System.out.println(subarraysWithKDistinct(A, K));
    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    public static int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
