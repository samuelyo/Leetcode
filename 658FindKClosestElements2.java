package com.leetcode.FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements2 {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);

		int k = 4;
		int x = -1;

		List<Integer> res = findClosestElements(arr, k, x);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

		int lo = 0, hi = arr.size() - k;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (x - arr.get(mid) > arr.get(mid + k) - x)
				lo = mid + 1;
			else
				hi = mid;
		}
		return arr.subList(lo, lo + k);

	}

}
