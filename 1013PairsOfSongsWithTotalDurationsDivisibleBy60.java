package com.leetcode.PairsOfSongsWithTotalDurationsDivisibleBy60;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(numPairsDivisibleBy60(time));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            if (count.containsKey(d)) {
                ans += count.get(d);
            } // in current HashMap, get the number of songs that add t to get a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return ans;
    }
}
