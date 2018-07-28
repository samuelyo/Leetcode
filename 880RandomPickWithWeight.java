package com.leetcode.RandomPickWithWeight;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int sum = 0;

    public RandomPickWithWeight(int[] w) {
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        int key = map.ceilingKey(new Random().nextInt(sum) + 1);
        return map.get(key);
    }
}
