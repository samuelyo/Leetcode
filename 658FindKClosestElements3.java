package com.leetcode.FindKClosestElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements3 {

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

		Collections.sort(arr, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
		arr = arr.subList(0, k);
		Collections.sort(arr);
		return arr;
		
	}

}
