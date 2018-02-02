package com.leetcode.HIndex;

import java.util.Arrays;

public class HIndex3 {

	public static void main(String[] args) {
		
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(hIndex(citations));

	}
	
	public static int hIndex(int[] citations) {
		
		Arrays.sort(citations);
		int index = citations.length - 1;
		while(index >= 0 && citations[index] >= citations.length - index) {
			index --;
		}
		return citations.length - index - 1;
		
	}

}
