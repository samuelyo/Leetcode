package com.leetcode.BitwiseORsOfSubarrays;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {
    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        System.out.println(subarrayBitwiseORs(A));
    }

    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            Set<Integer> temp = new HashSet<>();
            temp.add(cur);
            for (Integer num : set) {
                temp.add(num | cur);
            }
            set = temp;
            for (Integer num : set) {
                res.add(num);
            }
        }
        return res.size();
    }
}
