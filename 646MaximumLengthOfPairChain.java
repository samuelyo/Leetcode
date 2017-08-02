package com.leetcode.MaximumLengthOfPairChain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumLengthOfPairChain {

	public static void main(String[] args) {
		
		int[][] pairs = {{3,4},{2,3},{1,2}};
		System.out.println(findLongestChain(pairs));

	}
	
	public static int findLongestChain(int[][] pairs) {
		
		if(pairs == null || pairs.length == 0){
			return 0;
		}
		int len = pairs.length;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = 0;i<len;i++){
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(pairs[i][0]);
			cur.add(pairs[i][1]);
			list.add(cur);
		}
		Collections.sort(list, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				
				return o1.get(1) - o2.get(1);
			}
		});
		int[] res = new int[len];
		int max = Integer.MIN_VALUE;
		res[0] = 1;
		max = Math.max(max, res[0]);
		for(int i = 1;i<len;i++){
			int start = list.get(i).get(0);
			int maxPre = Integer.MIN_VALUE;
			for(int j = 0;j<i;j++){
				if(start > list.get(j).get(1))
				maxPre = Math.max(maxPre, res[j]);
			}
			res[i] = maxPre + 1;
			max = Math.max(max, res[i]);
		}
		return max;
		
	}

}
