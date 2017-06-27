package com.leetcode.MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MostFrequentSubtreeSum2 {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(-5);
		
		node1.left = node2;
		node1.right = node3;

		int[] ans = findFrequentTreeSum(node1);
		for(int i = 0;i<ans.length;i++){
			System.out.print(ans[i] + " ");
		}
				
	}
	
	public static Map<Integer, Integer> sumToCount;
    public static int maxCount;
    
	public static int[] findFrequentTreeSum(TreeNode root) {
		maxCount = 0;
        sumToCount = new HashMap<Integer, Integer>();
        
        postOrder(root);
        
        List<Integer> res = new ArrayList<Integer>();
        for (int key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    private static int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        int sum = left + right + root.val;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);
        
        maxCount = Math.max(maxCount, count);
        
        return sum;
		
	}

}
