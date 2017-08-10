package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode2 {

	public static void main(String[] args) {

		int n = 4;

		List<Integer> ans = grayCode(n);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> grayCode(int n) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < 1 << n; i++) {
			result.add(i ^ i >> 1);
		}	
		return result;

	}

}
