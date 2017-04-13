package com.leetcode.searchinsertposition;

import java.util.Arrays;

public class searchInsertPosition2 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int r = searchInsert2(nums, 7);
		System.out.println(r);
	}
	public static int searchInsert(int[] nums,int target){
		int pos = Arrays.binarySearch(nums, target);
//		return (pos < 0)?-pos-1:pos;
		return pos;
	}
	
	public static int searchInsert2(int[] nums,int target){
		
		int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        return low;  // key not found.
		
	}
}
