package com.leetcode.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {

		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> ans = combinationSum(candidates, target);
		for (int i = 0; i < ans.size(); i++) {
			List<Integer> res = ans.get(i);
			for (int j = 0; j < res.size(); j++) {
				System.out.print(res.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= target; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == candidates[j]) newList.add(Arrays.asList(candidates[j]));
                // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-candidates[j]-1)) {
                    if (candidates[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(candidates[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(target-1);
	}

}
