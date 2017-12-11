package com.leetcode.MinimumIndexSumOfTwoLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists3 {

	public static void main(String[] args) {
		
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		String[] ans = findRestaurant(list1, list2);
		for(int i = 0;i<ans.length;i++){
			System.out.print(ans[i] + " ");
		}

	}
	
	public static String[] findRestaurant(String[] list1, String[] list2) {
		
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for(int i = 0;i<list1.length;i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			map.put(list1[i], list);
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<list2.length;i++) {
			if(map.containsKey(list2[i])) {
				List<Integer> cur = map.get(list2[i]);
				cur.add(i);
				min = Math.min(min, cur.get(0) + cur.get(1));
			}
		}
		List<String> ret = new ArrayList<String>();
		for(String  key : map.keySet()) {
			if(map.get(key).size() == 2 && map.get(key).get(0) + map.get(key).get(1) == min) {
				ret.add(key);
			}
		}
		String[] res = new String[ret.size()];
		for(int i = 0;i<res.length;i++) {
			res[i] = ret.get(i);
		}
		return res;
		
	}

}
