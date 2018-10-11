package com.leetcode.DesignHashSet;

import java.util.HashMap;
import java.util.Map;

public class MyHashSet {
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        Integer temp = new Integer(key);
        int tempKey = temp.hashCode();
        if (!map.containsKey(tempKey)) {
            map.put(tempKey, key);
        }
    }

    public void remove(int key) {
        int tempKey = new Integer(key).hashCode();
        if (map.containsKey(tempKey)) {
            map.remove(tempKey);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int tempKey = new Integer(key).hashCode();
        return map.containsKey(tempKey);
    }
}
