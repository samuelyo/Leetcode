package com.leetcode.SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers2 {

	public static void main(String[] args) {

		int left = 1;
		int right = 22;
		List<Integer> res = selfDividingNumbers(left, right);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {
			int j = i;
			for (; j > 0; j /= 10) {
				if ((j % 10 == 0) || (i % (j % 10) != 0))
					break;
			}
			if (j == 0)
				list.add(i);
		}
		return list;

	}
}
