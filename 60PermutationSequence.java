package com.leetcode.PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		
		int n = 4;
		int k = 8;
		System.out.println(getPermutation(n, k));

	}
	
	public static String getPermutation(int n, int k) {
		
		int dul = 1;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1;i<=n;i++){
			dul *= i;
			list.add(i);
		}
		dul /= n;
		StringBuilder res = new StringBuilder();
		int times = n-1;
		while(res.length() < n){
			if(k == 0){
				for(int i = list.size()-1;i>=0;i--){
					res.append(list.get(i));
				}
				break;
			}
			if(k == 1){
				for(int i = 0;i<list.size();i++){
					res.append(list.get(i));
				}
				break;
			}
			k += (dul - 1);
			int index = k/dul;
			int cur = list.get(index-1);
			res.append(cur);
			list.remove(index-1);
			k -= (dul - 1);
			k -= (index-1) * dul;
			dul /= times;
			times --;
		}
		return res.toString();
	}

}
