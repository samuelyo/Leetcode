package com.leetcode.distributecandies;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies2 {

	public static void main(String[] args) {
		
		int[] candies = {1,1,2,3};
		System.out.println(distributeCandies(candies));

	}
	
	public static int distributeCandies(int[] candies){
		
		Set<Integer> kinds = new HashSet<>();
		for (int candy : candies){
			kinds.add(candy);
		}
		return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
	}

}
