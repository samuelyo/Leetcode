package com.leetcode.HIndexII;

import java.util.Arrays;

public class HIndexII2 {

	public static void main(String[] args) {

		int[] citations = { 0, 1, 3, 5, 6 };
		System.out.println(hIndex(citations));

	}

	public static int hIndex(int[] citations) {

		int ans = 0;
		int count = 0;
		int len = citations.length;
		if(len == 1){
			if(citations[0] == 0){
				return 0;
			}else{
				return 1;
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			count++;
			if (i > 0 && citations[i - 1] <= count && citations[i] >= count ) {
				ans = count;
				break;
			}
			if( i == 0){
				if(citations[0] >= count){
					ans = count;
				}
			}
		}
		return ans;
				
	}

}
