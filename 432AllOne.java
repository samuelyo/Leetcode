package com.leetcode.AllOoneDataStructure;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AllOne {

	Map<String, Integer> map;
	
	/** Initialize your data structure here. */
	public AllOne() {

		map = new HashMap<String, Integer>();
		
	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {

		if(map.containsKey(key)) {
			map.put(key, map.get(key) + 1);
		}else{
			map.put(key, 1);
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {

		if(map.containsKey(key)) {
			if(map.get(key) - 1 == 0) {
				map.remove(key);
				return;
			}else{
				map.put(key, map.get(key) - 1);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			
				return o1.getValue() - o2.getValue();
			}
		});
		
		if(list.size() == 0) {
			return "";
		}
		return list.get(list.size() - 1).getKey();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			
				return o1.getValue() - o2.getValue();
			}
		});
		
		if(list.size() == 0) {
			return "";
		}
		return list.get(0).getKey();
		
	}
}
