package com.leetcode.removeduplicates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static int removeDuplicates(int[] nums){
		int changed = 1;  
        int n = 1;  
        while( n < nums.length){  
            if( nums[n] != nums[changed-1]){  
                nums[changed] = nums[n];  
                changed++;  
            }  
            n++;  
              
        }  
        return changed;  
	}
	
	public static void main(String[] args) {
		
		int[] nums = {1,3,2,2,2,3,3,4,4};
		removeDuplicates(nums);
	}

}
