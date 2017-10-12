package com.leetcode.LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache2 {

	HashMap<Integer, Integer> vals;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, LinkedHashSet<Integer>> lists;
	int cap;
	int min = -1;

	public LFUCache2(int capacity) {
	        cap = capacity;
	        vals = new HashMap<>();
	        counts = new HashMap<>();
	        lists = new HashMap<>();
	        lists.put(1, new LinkedHashSet<>());
	    }

	public int get(int key) {
		if (!vals.containsKey(key))
			return -1;
		int count = counts.get(key);
		counts.put(key, count + 1);
		lists.get(count).remove(key);// remove key from current count (since we will inc count)
		if (count == min && lists.get(count).size() == 0)// nothing in the current min bucket
			min++;
		if (!lists.containsKey(count + 1))
			lists.put(count + 1, new LinkedHashSet<>());
		lists.get(count + 1).add(key);
		return vals.get(key);
	}

	public void put(int key, int value) {
		if (cap <= 0)
			return;
		if (vals.containsKey(key)) {
			vals.put(key, value);// update key's value
			get(key);// update key's count
			return;
		}
		if (vals.size() >= cap) {
			int evit = lists.get(min).iterator().next(); // evict LRU from this min count bucket
			lists.get(min).remove(evit);
			vals.remove(evit);
		}
		vals.put(key, value);// adding new key and value
		counts.put(key, 1);// adding new key and count
		min = 1;
		lists.get(1).add(key);
	}

}
