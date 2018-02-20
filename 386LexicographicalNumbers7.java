package com.leetcode.LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers7 {

	public static void main(String[] args) {
		
		int n = 13;
		List<Integer> res = lexicalOrder(n);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}
		
	}

	public static List<Integer> lexicalOrder(int n) {
		
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 1;i<=9;i++) {
			lexicalOrderHelp(res, n, i);
		}
		return res;
		
	}
	
	public static void lexicalOrderHelp(List<Integer> res, int n, int cur) {
		
		if(cur <= n) {
			res.add(cur);
			cur *= 10;
			for(int i = 0;i<=9;i++) {
				if(cur + i <= n) {
					lexicalOrderHelp(res, n, cur + i);
				}
			}
		}
		
	}
}
