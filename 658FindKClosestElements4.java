package com.leetcode.FindKClosestElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements4 {

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

		List<Integer> less = new ArrayList<>(), greater = new ArrayList<>(), lessResult = new LinkedList<>(),
				greaterResult = new LinkedList<>();

		for (Integer i : arr) {
			if (i <= x)
				less.add(i);
			else
				greater.add(i);
		}

		Collections.reverse(less);
		int i = 0, j = 0, n = less.size(), m = greater.size();
		for (int size = 0; size < k; size++) {
			if (i < n && j < m) {
				if (Math.abs(less.get(i) - x) <= Math.abs(greater.get(j) - x))
					lessResult.add(less.get(i++));
				else
					greaterResult.add(greater.get(j++));
			} else if (i < n)
				lessResult.add(less.get(i++));
			else
				greaterResult.add(greater.get(j++));
		}

		Collections.reverse(lessResult);
		lessResult.addAll(greaterResult);
		return lessResult;

	}

}
