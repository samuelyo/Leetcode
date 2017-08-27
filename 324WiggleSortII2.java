package com.leetcode.WiggleSortII;

public class WiggleSortII2 {

	public static void main(String[] args) {

		int[] nums = { 4, 5, 5, 6 };
		wiggleSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static void wiggleSort(int[] nums) {

		if (nums == null || nums.length == 0)
			return;
		int len = nums.length;
		int median = findMedian(0, len - 1, len / 2, nums);
		int left = 0, right = len - 1, i = 0;
		// map current index firstly
		while (i <= right) {
			int mappedCurIndex = newIndex(i, len);
			if (nums[mappedCurIndex] > median) {
				int mappedLeftIndex = newIndex(left, len);
				swap(mappedLeftIndex, mappedCurIndex, nums);
				left++;
				i++;
			} else if (nums[mappedCurIndex] < median) {
				int mappedRightIndex = newIndex(right, len);
				swap(mappedCurIndex, mappedRightIndex, nums);
				right--;
			} else {
				i++;
			}
		}
	}

	// {0,1,2,3,4,5} -> {1,3,5,0,2,4}
	// find mapped new index
	public static int newIndex(int index, int len) {
		return (1 + 2 * index) % (len | 1);
	}

	// use quicksort, average O(n) time
	public static int findMedian(int start, int end, int k, int[] nums) {
		if (start > end)
			return Integer.MAX_VALUE;
		int pivot = nums[end];
		int indexOfWall = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) {
				swap(i, indexOfWall, nums);
				indexOfWall++;
			}
		}
		swap(indexOfWall, end, nums);
		if (indexOfWall == k) {
			return nums[indexOfWall];
		} else if (indexOfWall < k) {
			return findMedian(indexOfWall + 1, end, k, nums);
		} else {
			return findMedian(start, indexOfWall - 1, k, nums);
		}
	}

	public static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
