package com.leetcode.BitwiseORsOfSubarrays;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        System.out.println(subarrayBitwiseORs(A));
    }

    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), cur2;
        for (Integer i : A) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (Integer j : cur) cur2.add(i | j);
            cur = cur2;
            for (Integer j : cur) res.add(j);
        }
        return res.size();
    }
}
