package com.leetcode.SplitArrayWithSameAverage;

import java.util.HashSet;

public class SplitArrayWithSameAverage2 {

	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(splitArraySameAverage(A));

	}

	public static boolean splitArraySameAverage(int[] A) {
		
		if(A == null || A.length == 0) {
			return false;
		}
		int sum = 0;
		for(int num : A) {
			sum += num;
		}
		HashSet<Integer>[] sets = new HashSet[A.length / 2 + 1];
		for(int i = 0;i<sets.length;i++) {
			sets[i] = new HashSet<Integer>();
		}
		sets[0].add(0);
		for(int num : A) {
			for(int j = sets.length - 1;j>=1;j--) {
				for(Integer temp : sets[j - 1]) {
					if(isValid(temp + num, sum - (temp + num), j, A.length - j)) {
						return true;
					}
					sets[j].add(temp + num);
				}
			}
		}
		return false;
		
	}
	
	public static boolean isValid(int sum1, int sum2, int len1, int len2) {
		
		return sum1 * len2 == sum2 * len1;
	}
}
