package com.leetcode.ConstructTheRectangle;

import java.util.Arrays;

public class ConstructTheRectangle3 {

	public static void main(String[] args) {
		
		int area = 2;
		int[] res = constructRectangle(area);
		System.out.println(Arrays.toString(res));

	}
	
	public static int[] constructRectangle(int area) {
		
		for(int width = (int) Math.sqrt(area);width >= 1;width --) {
			if(area % width == 0) {
				int length = area / width;
				if(width <= length) {
					return new int[]{length, width};
				}
			}
		}
		return new int[2];
		
	}

}
