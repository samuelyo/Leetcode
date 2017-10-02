package com.leetcode.MapSumPairs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class MapSum {

	TreeMap<String,Integer> map;
	Set<String>[] sets;
	
	/** Initialize your data structure here. */
	public MapSum() {

		map = new TreeMap<String,Integer>();
		sets = new HashSet[256];
		for(int i = 0;i<256;i++) {
			sets[i] = new HashSet<String>();
		}
	}

	public void insert(String key, int val) {

		map.put(key, val);
		Character c = key.charAt(0);
		sets[c - 'a'].add(key);
	}

	public int sum(String prefix) {

		int count = 0;
		Set<String> set = sets[prefix.charAt(0) - 'a'];
		List<String> list = new ArrayList<String>(set);
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).startsWith(prefix)) {
				count += map.get(list.get(i));
			}
		}
		return count;
		
	}
	
}
