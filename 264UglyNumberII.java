package com.leetcode.UglyNumberII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UglyNumberII {

	public static void main(String[] args) {

		int n = 1600;
		System.out.println(nthUglyNumber(n));

	}

	public static int nthUglyNumber(int n) {

		List<Integer> ugly = new ArrayList<Integer>();
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		ugly.add(1);
		ugly.add(2);
		int twoIndex = 0;
		int threeIndex = 0;
		int fiveIndex = 0;
		for(int i = 2;i < n;i++){
			while(2 * ugly.get(twoIndex) <= ugly.get(ugly.size() - 1)){
				twoIndex ++;
			}
			int two = 2 * ugly.get(twoIndex);
			while(3 * ugly.get(threeIndex) <= ugly.get(ugly.size() - 1)){
				threeIndex ++;
			}
			int three = 3 * ugly.get(threeIndex);
			while(5 * ugly.get(fiveIndex) <= ugly.get(ugly.size() - 1)){
				fiveIndex ++;
			}
			int five = 5 * ugly.get(fiveIndex);
			ugly.add(Math.min(two, Math.min(three, five)));
		}
		return ugly.get(ugly.size() - 1);
	}

}
