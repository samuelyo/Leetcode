package com.leetcode.FourSumII;

import java.util.HashMap;
import java.util.Map;

public class FourSumII3 {

	public static void main(String[] args) {

		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		int ans = fourSumCount(A, B, C, D);
		System.out.println(ans);

	}

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		
		if(A == null || B == null || C == null || D == null || A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
			return 0;
		}
		int len = A.length;
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for(int i = 0;i<len;i++) {
			for(int j = 0;j<len;j++) {
				map1.put(A[i] + B[j], map1.getOrDefault(A[i] + B[j], 0) + 1);
			}
		}
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for(int i = 0;i<len;i++) {
			for(int j = 0;j<len;j++) {
				map2.put(C[i] + D[j], map2.getOrDefault(C[i] + D[j], 0) + 1);
			}
		}
		int res = 0;
		for(Integer key1 : map1.keySet()) {
			if(map2.containsKey(0 - key1)) {
				res += map1.get(key1) * map2.get(0 - key1);
			}
		}
		return res;
		
	}

}
