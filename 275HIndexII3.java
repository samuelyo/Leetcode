package com.leetcode.HIndexII;

public class HIndexII3 {

	public static void main(String[] args) {
		
		int[] citations = { 0, 1, 3, 5, 6 };
		System.out.println(hIndex(citations));

	}
	
	public static int hIndex(int[] citations) {
		
		int index = citations.length - 1;
		while(index >= 0 && citations[index] >= citations.length - index) {
			index --;
		}
		return citations.length - index - 1;
		
	}

}
