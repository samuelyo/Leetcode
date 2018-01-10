package com.leetcode.UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII4 {

	public static void main(String[] args) {
		
		int n = 3;
		List<TreeNode> ans = generateTrees(n);
		System.out.println(ans.size());
		for(TreeNode node : ans) {
			System.out.print(node.val + " ");
		}

	}
	
	public static List<TreeNode> generateTrees(int n) {
		
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(n <= 0) {
			return res;
		}
		return generateTreesHelp(1, n);

	}
	
	public static List<TreeNode> generateTreesHelp(int start, int end) {
		
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(start > end) {
			return res;
		}
		if(start == end) {
			TreeNode node = new TreeNode(start);
			res.add(node);
			return res;
		}
		for(int i = start;i<=end;i++) {
			List<TreeNode> lefts = generateTreesHelp(start, i - 1);
			List<TreeNode> rights = generateTreesHelp(i + 1, end);
			if(lefts.size() == 0 && rights.size() == 0) {
				continue;
			}
			if(lefts.size() == 0 && rights.size() != 0) {
				for(TreeNode right : rights) {
					TreeNode root = new TreeNode(i);
					root.right = right;
					res.add(root);
				}
			}
			if(lefts.size() != 0 && rights.size() == 0) {
				for(TreeNode left : lefts) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					res.add(root);
				}
			}
			for(TreeNode left : lefts) {
				for(TreeNode right : rights) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
		
	}

}
