package com.leetcode.MaximumDistanceInArrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumDistanceInArrays2 {

	public static void main(String[] args) {

		List<List<Integer>> arrays = new ArrayList<List<Integer>>();
		List<Integer> res1 = new ArrayList<Integer>();
		res1.add(-8);
		res1.add(4);
		arrays.add(res1);
		List<Integer> res2 = new ArrayList<Integer>();
		res2.add(2);
		res2.add(3);
		res2.add(5);
		arrays.add(res2);
		List<Integer> res3 = new ArrayList<Integer>();
		res3.add(1);
		res3.add(5);
		// res3.add(3);
		arrays.add(res3);

		System.out.println(maxDistance(arrays));

	}

	public static int maxDistance(List<List<Integer>> arrays) {

		int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        
        return result;

		
	}

}
