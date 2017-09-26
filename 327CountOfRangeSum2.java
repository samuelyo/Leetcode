package com.leetcode.CountOfRangeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountOfRangeSum2 {

	static class SegmentTreeNode {
		SegmentTreeNode left;
		SegmentTreeNode right;
		int count;
		long min;
		long max;

		public SegmentTreeNode(long min, long max) {
			this.min = min;
			this.max = max;
		}
	}

	private static SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
		if (low > high)
			return null;
		SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
		if (low == high)
			return stn;
		int mid = (low + high) / 2;
		stn.left = buildSegmentTree(valArr, low, mid);
		stn.right = buildSegmentTree(valArr, mid + 1, high);
		return stn;
	}

	private static void updateSegmentTree(SegmentTreeNode stn, Long val) {
		if (stn == null)
			return;
		if (val >= stn.min && val <= stn.max) {
			stn.count++;
			updateSegmentTree(stn.left, val);
			updateSegmentTree(stn.right, val);
		}
	}

	private static int getCount(SegmentTreeNode stn, long min, long max) {
		if (stn == null)
			return 0;
		if (min > stn.max || max < stn.min)
			return 0;
		if (min <= stn.min && max >= stn.max)
			return stn.count;
		return getCount(stn.left, min, max) + getCount(stn.right, min, max);
	}

	public static void main(String[] args) {

		int[] nums = { -2, 5, -1 };
		int lower = -2;
		int upper = 2;
		System.out.println(countRangeSum(nums, lower, upper));

	}

	public static int countRangeSum(int[] nums, int lower, int upper) {

		if (nums == null || nums.length == 0)
			return 0;
		int ans = 0;
		Set<Long> valSet = new HashSet<Long>();
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (long) nums[i];
			valSet.add(sum);
		}

		Long[] valArr = valSet.toArray(new Long[0]);

		Arrays.sort(valArr);
		SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length - 1);

		for (int i = nums.length - 1; i >= 0; i--) {
			updateSegmentTree(root, sum);
			sum -= (long) nums[i];
			ans += getCount(root, (long) lower + sum, (long) upper + sum);
		}
		return ans;
	}

}
