package com.leetcode.PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence3 {

	public static void main(String[] args) {
		
		int n = 4;
		int k = 24;
		System.out.println(getPermutation(n, k));
		
	}
	
	public static String getPermutation(int n, int k) {
		
		List<Integer> list = new ArrayList<Integer>();
		long sum = 1;
		int i = 1;
		for(;i<n;i++) {
			list.add(i);
			sum *= i;
		}
		list.add(i);
		i--;
		StringBuilder sb = new StringBuilder();
		while(k > 0) {
			int index = (int) ((k + sum - 1) / sum - 1);
			sb.append(list.get(index));
			list.remove(index);
			if(list.size() == 0) {
				break ;
			}
			k -= index * sum;
			sum /= i;
			i --;
		}
		return sb.toString();
		
	}
}
