package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode4 {

	public static void main(String[] args) {

		int n = 2;

		List<Integer> ans = grayCode(n);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> grayCode(int n) {

		List<Integer> rs = new ArrayList<Integer>();
		rs.add(0);
		for (int i = 0; i < n; i++) {
			int size = rs.size();
			for (int k = size - 1; k >= 0; k--)
				rs.add(rs.get(k) | 1 << i);
		}
		return rs;

	}

}
