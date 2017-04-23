package com.leetcode.majorityelement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement2 {

	public static void main(String[] args) {
		
		int[] nums = {3,2,3,2,3};
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums){
		
		//Boyer-Moore Algorithm
		int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;
            
        }
        return major;
        
	}
}
