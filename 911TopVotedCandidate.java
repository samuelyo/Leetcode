package com.leetcode.OnlineElection;

import java.util.TreeMap;

public class TopVotedCandidate {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int[] p;
    Integer max = null;

    public TopVotedCandidate(int[] persons, int[] times) {
        p = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            p[persons[i]]++;
            Integer res = null;
            if (max == null) {
                res = persons[i];
                max = persons[i];
            } else {
                if (p[persons[i]] > p[max]) {
                    res = persons[i];
                    max = persons[i];
                } else if (p[persons[i]] < p[max]) {
                    res = max;
                } else {
                    res = persons[i];
                    max = persons[i];
                }
            }
            map.put(times[i], res);
        }
    }

    public int q(int t) {
        return map.get(map.floorKey(t));
    }
}
