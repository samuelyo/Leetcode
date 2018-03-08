package com.leetcode.CircularArrayLoop;

public class CircularArrayLoop4 {

	public static void main(String[] args) {
		
		int[] nums = {2, -1, 1, 2, 2};
		System.out.println(circularArrayLoop(nums));

	}
	
	public static boolean circularArrayLoop(int[] nums) {
		
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] == 0) {
				continue;
			}
			int slow = i;
			int fast = next(nums, slow);
			while(nums[fast] * nums[i] > 0 && nums[next(nums, fast)] * nums[i] > 0) {
				if(slow == fast) {
					if (slow == next(nums, slow)) {
						break;
					}
					return true;
				}
				slow = next(nums, slow);
				fast = next(nums, next(nums, fast));
			}
			int temp = i;
			while(nums[temp] * nums[i] > 0) {
				nums[temp] = 0;
				temp = next(nums, temp);
			}
		}
		return false;
		
	}
	
	public static int next(int[] nums, int index) {
		
		if(index + nums[index] >= nums.length) {
			return (index + nums[index]) % nums.length;
		}else if(index + nums[index] < 0) {
			return index + nums[index] + nums.length;
		}else {
			return index + nums[index];
		}
		
	}

}
