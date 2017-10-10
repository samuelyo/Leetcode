package com.leetcode.CreateMaximumNumber;

public class CreateMaximumNumber2 {

	public static void main(String[] args) {

		int[] nums1 = { 3, 9 };
		int[] nums2 = { 8, 9 };
		int k = 3;
		int[] res = maxNumber(nums1, nums2, k);
		for (int i = 0; i < k; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

		int n = nums1.length;
		int m = nums2.length;
		int[] ans = new int[k];
		for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
			int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			if (greater(candidate, 0, ans, 0))
				ans = candidate;
		}
		return ans;
	}

	private static int[] merge(int[] nums1, int[] nums2, int k) {
		
		int[] ans = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; ++r)
			ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		return ans;
	}

	public static boolean greater(int[] nums1, int i, int[] nums2, int j) {
		
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}

	public static int[] maxArray(int[] nums, int k) {
		
		int n = nums.length;
		int[] ans = new int[k];
		for (int i = 0, j = 0; i < n; ++i) {
			while (n - i + j > k && j > 0 && ans[j - 1] < nums[i])
				j--;
			if (j < k)
				ans[j++] = nums[i];
		}
		return ans;

	}

}
