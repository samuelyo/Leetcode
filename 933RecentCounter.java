package com.leetcode.NumberOfRecentCalls;

import java.util.TreeMap;

public class RecentCounter {
    private TreeMap<Integer, Integer> map;

    public RecentCounter() {
        map = new TreeMap<>();
    }

    public int ping(int t) {
        int pre = 0;
        if (map.floorKey(t) != null) {
            pre = map.get(map.floorKey(t));
        }
        map.put(t, pre + 1);
        return pre + 2 - map.get(map.ceilingKey(t - 3000));
    }
}
