package com.leetcode.TopKFrequentElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements3 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,1,2,2,2,3};
		int k = 2;
		List<Integer> ans = topKFrequent(nums, k);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i], 1);
			}
		}
		List<int[]> list = new ArrayList<int[]>();
		for(Integer key : map.keySet()) {
			list.add(new int[]{map.get(key), key});
		}
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
			
		});
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<k;i++) {
			res.add(list.get(i)[1]);
		}
		return res;
		
	}
}
