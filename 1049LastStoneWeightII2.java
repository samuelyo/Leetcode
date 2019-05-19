package com.leetcode.LastStoneWeightII;

import java.util.HashSet;
import java.util.Set;

public class LastStoneWeightII2 {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int res = lastStoneWeightII(stones);
        System.out.println(res);
    }

    public static int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(stones[0]);
        set.add(-stones[0]);
        for (int i = 1; i < stones.length; i++) {
            Set<Integer> set2 = new HashSet<>();
            for (int item : set) {
                set2.add(item + stones[i]);
                set2.add(item - stones[i]);
            }
            set = set2;
        }
        int min = Integer.MAX_VALUE;
        for (int item : set) min = Math.min(Math.abs(item), min);
        return min;
    }
}
