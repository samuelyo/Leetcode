package com.leetcode.CountPrimes;

public class CountPrimes2 {

	public static void main(String[] args) {

		int n = 100;
		System.out.println(countPrimes(n));

	}

	public static int countPrimes(int n) {

		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrime[i] == false) {
				count++;
				if(i*i < n){ //check up to Math.sqrt(n)
					for (int j = 2; i * j < n; j++) {
						notPrime[i * j] = true;
					}
				}
			}
		}

		return count;
	}

}
