package com.leetcode.tuosumII;

import java.util.Arrays;

public class TwoSumII2 {

	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4,4};
		int[] r = twosum(numbers, 8);
		System.out.println(Arrays.toString(r));
	}

	public static int[] twosum(int[] numbers,int target){
		
		int[] indice = new int[2];
	    if (numbers == null || numbers.length < 2) return indice;
	    int left = 0, right = numbers.length - 1;
	    while (left < right) {
	        int v = numbers[left] + numbers[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
	
}
