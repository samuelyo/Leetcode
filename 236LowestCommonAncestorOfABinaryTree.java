package com.leetcode.LowestCommonAncestorOfABinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {

	public static void main(String[] args) {

//		TreeNode root = new TreeNode(3);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node0 = new TreeNode(0);
//		TreeNode node8 = new TreeNode(8);
//		TreeNode node7 = new TreeNode(7);
//		TreeNode node4 = new TreeNode(4);

//		root.left = node5;
//		root.right = node1;
//		node5.left = node6;
//		node5.right = node2;
//		node1.left = node0;
//		node1.right = node8;
//		node2.left = node7;
//		node2.right = node4;
		
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		root.left = node2;

		TreeNode res = lowestCommonAncestor(root, node2, root);
		System.out.println(res.val);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		List<List<TreeNode>> paths = new ArrayList<List<TreeNode>>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		paths = lowestCommonAncestorHelp(root, paths, list, p, q);
		if(paths.size() == 1){
			for(int i = 0;i<paths.get(0).size();i++){
				if(paths.get(0).get(i) == p || paths.get(0).get(i) == q){
					return paths.get(0).get(i);
				}
			}
			return null;
		}else{
			List<TreeNode> list1 = paths.get(0);
			List<TreeNode> list2 = paths.get(1);
			List<TreeNode> pList,qList;
			if(list1.get(list1.size() - 1) == p){
				pList = list1;
				qList = list2;
			}else{
				pList = list2;
				qList = list1;
			}
			for (int i = pList.size() - 1; i >= 0; i--) {
				if (qList.contains(pList.get(i))) {
					return pList.get(i);
				}
			}
			return null;
		}
		
	}

	public static List<List<TreeNode>> lowestCommonAncestorHelp(TreeNode node, List<List<TreeNode>> paths,
			List<TreeNode> list, TreeNode p, TreeNode q) {

		if (node == null) {
			return paths;
		}
		if (node == p || node == q) {
			list.add(node);
			paths.add(new ArrayList<TreeNode>(list));
			list.remove(list.size() - 1);
			return paths;
		} else {
			list.add(node);
			lowestCommonAncestorHelp(node.left, paths, list, p, q);
			lowestCommonAncestorHelp(node.right, paths, list, p, q);
			list.remove(list.size() - 1);
			return paths;
		}

	}

}
