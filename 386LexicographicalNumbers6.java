package com.leetcode.LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers6 {

	public static void main(String[] args) {
		
		int n = 20;
		List<Integer> res = lexicalOrder(n);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}
		
	}

	public static List<Integer> lexicalOrder(int n) {
		
		List<Integer> res = new ArrayList<Integer>();
		int cur = 1;
		for(int i = 1;i<=n;i++) {
			res.add(cur);
			if(cur * 10 <= n) {
				cur *= 10;
			}else if(cur % 10 != 9 && cur + 1 <= n) {
				cur ++;
			}else {
				while((cur / 10) % 10 == 9) {
					cur /= 10;
				}
				cur = cur / 10 + 1;
			}
		}
		return res;
		
	}
}
