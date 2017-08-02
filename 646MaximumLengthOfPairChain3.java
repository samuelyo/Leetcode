package com.leetcode.MaximumLengthOfPairChain;

import java.util.Arrays;


public class MaximumLengthOfPairChain3 {

	public static void main(String[] args) {
		
		int[][] pairs = {{3,4},{2,3},{1,2}};
		System.out.println(findLongestChain(pairs));

	}
	
	public static int findLongestChain(int[][] pairs) {
		
		if(pairs == null || pairs.length == 0){
			return 0;
		}
		int len = pairs.length;
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		int[] res = new int[len];
		int max = Integer.MIN_VALUE;
		res[0] = 1;
		max = Math.max(max, res[0]);
		for(int i = 1;i<len;i++){
			int start = pairs[i][0];
			int maxPre = Integer.MIN_VALUE;
			for(int j = 0;j<i;j++){
				if(start > pairs[j][1])
				maxPre = Math.max(maxPre, res[j]);
			}
			res[i] = maxPre + 1;
			max = Math.max(max, res[i]);
		}
		return max;
		
	}

}
