package com.leetcode.DistributeCandies;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies3 {

	public static void main(String[] args) {
		
		int[] candies = {1,1,2,2,3,3};
		System.out.println(distributeCandies(candies));

	}

	public static int distributeCandies(int[] candies) {
		
		int len = candies.length / 2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<candies.length;i++) {
			map.put(candies[i], map.getOrDefault(candies[i], 1));
		}
		int res = 0;
		for(Integer key : map.keySet()) {
			if(map.get(key) > 0) {
				res ++;
				map.put(key, map.get(key) - 1);
				len --;
				if(len == 0) {
					break;
				}
			}
		}
		return res;
		
	}
}
