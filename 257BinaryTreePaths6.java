package com.leetcode.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths6 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;

		List<String> res = binaryTreePaths(t1);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<String> binaryTreePaths(TreeNode root) {

		List<String> res = new ArrayList<String>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		list.add(root.val);
		binaryTreePathsHelp(root, res, list);
		return res;
		
	}
	
	public static void binaryTreePathsHelp(TreeNode root, List<String> res, List<Integer> list) {
		
		if(root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<list.size();i++) {
				if(i == list.size() - 1) {
					sb.append(list.get(i));
				}else {
					sb.append(list.get(i) + "->");
				}
			}
			res.add(sb.toString());
		}
		
		if(root.left != null) {
			list.add(root.left.val);
			binaryTreePathsHelp(root.left, res, list);
			list.remove(list.size() - 1);
		}
		
		if(root.right != null) {
			list.add(root.right.val);
			binaryTreePathsHelp(root.right, res, list);
			list.remove(list.size() - 1);
		}
		
	}
}
