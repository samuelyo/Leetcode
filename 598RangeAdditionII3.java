package com.leetcode.RangeAdditionII;

public class RangeAdditionII3 {

	public static void main(String[] args) {
		
		int m = 3;
		int n = 3;
		int[][] ops = {{2,2},{3,3}};
		System.out.println(maxCount(m, n, ops));

	}
	
	public static int maxCount(int m, int n, int[][] ops) {
		
		if(ops == null || ops.length == 0 || ops[0].length == 0) {
			return m * n;
		}
		int len = ops[0][0];
		int wid = ops[0][1];
		
		for(int i = 1;i<ops.length;i++) {
			int[] cur = ops[i];
			len = Math.min(len, cur[0]);
			wid = Math.min(wid, cur[1]);
		}
		return len * wid;
		
	}

}
