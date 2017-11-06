package com.leetcode.TwoSumInputArrayIsSortedII;

import java.util.Arrays;

public class TwoSumII3 {

	public static void main(String[] args) {
		
		int[] numbers = {2,7,11,5};
		int[] r = twosum(numbers, 9);
		System.out.println(Arrays.toString(r));
	}

	public static int[] twosum(int[] numbers,int target){
		
		int[] res = new int[2];
		int index = 0;
		while(index < numbers.length - 1 && numbers[index] <= target / 2) {
			int tar = target - numbers[index];
			res[0] = index + 1;
			int left = index + 1;
			int right = numbers.length;
			int ind = Arrays.binarySearch(numbers, left, right, tar);
			if(ind > 0) {
				res[1] = ind + 1;
				return res;
			}
			index ++;
		}
		return res;
		
	}
	
}
