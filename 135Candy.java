package com.leetcode.Candy;

import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		
		int[] ratings = {3,4,5,2,3};
		System.out.println(candy(ratings));

	}
	
	public static int candy(int[] ratings) {
		
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for(int i = 0;i<ratings.length - 1;i++) {
			if(ratings[i] < ratings[i+1]) {
				candy[i+1] = candy[i] + 1;
			}
		}
		for(int i = ratings.length - 1;i>0;i--) {
			if(ratings[i] < ratings[i - 1]) {
				candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
			}
		}
		int res = 0;
		for(int i = 0;i<candy.length;i++) {
			res += candy[i];
		}
		return res;
		
		
	}

}
