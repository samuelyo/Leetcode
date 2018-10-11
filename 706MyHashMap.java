package com.leetcode.DesignHashMap;

public class MyHashMap {
    private Integer[] dp;
    private static int bucketSize = 1000000;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        dp = new Integer[bucketSize];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        dp[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (dp[key] != null) {
            return dp[key];
        } else {
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (dp[key] == null) {
            return;
        } else {
            dp[key] = null;
        }
    }
}
