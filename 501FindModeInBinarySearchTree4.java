package com.leetcode.FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree4 {

	public static void main(String[] args) {
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
//		TreeNode t5 = new TreeNode(3);
		
		t1.right = t2;
		t2.left = t3;
		t2.right = t4;
//		t4.left = t5;
		
		int[] res = findMode(t1);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}
		
	}
	
	public static int[] findMode(TreeNode root) {
		
		if(root == null) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>();
		inOrderTraverse(root, list);
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for(int i = 0;i<list.size();i++) {
			int cur = list.get(i);
			if(map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			}else {
				map.put(cur, 1);
			}
			max = Math.max(max, map.get(cur));
		}
		for(Integer key : map.keySet()) {
			if(map.get(key) == max) {
				res.add(key);
			}
		}
		int[] ret = new int[res.size()];
		for(int i = 0;i<ret.length;i++) {
			ret[i] = res.get(i);
		}
		return ret;
		
	}
	
	public static void inOrderTraverse(TreeNode root, List<Integer> list) {
		
		if(root == null) {
			return ;
		}
		inOrderTraverse(root.left, list);
		list.add(root.val);
		inOrderTraverse(root.right, list);
		
	}

}
