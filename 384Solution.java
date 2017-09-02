package com.leetcode.ShuffleAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int[] nums;
	public List<Integer> list;
	
	public Solution(int[] nums) {
        
		this.nums = nums;
		list = new ArrayList<Integer>();
		for(int i = 0;i<nums.length;i++){
			list.add(nums[i]);
		}
		
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
    	return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
    	List<Integer> temp = new ArrayList<Integer>(list);
    	int[] res = new int[nums.length];
    	int index = 0;
    	int tempIndex; 
    	while(index < nums.length){
    		do{
    			tempIndex = (int) (Math.random() * temp.size());
    		}while(temp.get(tempIndex) == null);
    		res[index] = temp.get(tempIndex);
    		temp.set(tempIndex, null);
    		index ++;
    	}
    	return res;
    	
    }
    
    
}
