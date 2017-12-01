package com.leetcode.Heaters;

import java.util.Arrays;

public class Heaters4 {

	public static void main(String[] args) {
		
		int[] houses = {1,2,3,4};
		int[] heaters = {1,4};
		System.out.println(findRadius(houses, heaters));

	}
	
	public static int findRadius(int[] houses, int[] heaters) {
		
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int index = 0;
		int res = 0;
		for(int house : houses) {
			while(index < heaters.length - 1 && Math.abs(heaters[index + 1] - house) 
					<= Math.abs(heaters[index] - house)) {
				index ++;
			}
			res = Math.max(res, Math.abs(heaters[index] - house));
		}
		return res;
		
	}

}
