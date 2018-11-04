package com.leetcode.NumberOfRecentCalls;

import java.util.TreeMap;

public class RecentCounter2 {
    TreeMap<Integer, Integer> tm;

    public RecentCounter2() {
        tm = new TreeMap<>();
    }

    public int ping(int t) {
        tm.put(t, 1 + tm.size());
        return tm.tailMap(t - 3000).size();
    }
}
