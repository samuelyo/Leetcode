package com.leetcode.SuperUglyNumber;

import java.util.ArrayList;
import java.util.List;

public class SuperUglyNumber4 {

	public static void main(String[] args) {
		
		int n = 12;
		int[] primes = {2, 7, 13, 19};
		System.out.println(nthSuperUglyNumber(n, primes));

	}
	
	public static int nthSuperUglyNumber(int n, int[] primes) {
		
		int[] index = new int[primes.length];
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		while(list.size() < n) {
			int temp = Integer.MAX_VALUE;
			for(int i = 0;i<primes.length;i++) {
				temp = Math.min(temp, primes[i] * list.get(index[i]));
			}
			list.add(temp);
			for(int i = 0;i<primes.length;i++) {
				while(primes[i] * list.get(index[i]) <= list.get(list.size() - 1)) {
					index[i] ++;
				}
			}
		}
		return list.get(list.size() - 1);
		
	}

}
