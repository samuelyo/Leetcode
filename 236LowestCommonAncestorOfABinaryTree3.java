package com.leetcode.LowestCommonAncestorOfABinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree3 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node0 = new TreeNode(0);
		TreeNode node8 = new TreeNode(8);
		TreeNode node7 = new TreeNode(7);
		TreeNode node4 = new TreeNode(4);

		root.left = node5;
		root.right = node1;
		node5.left = node6;
		node5.right = node2;
		node1.left = node0;
		node1.right = node8;
		node2.left = node7;
		node2.right = node4;

        System.out.println(lowestCommonAncestor(root, node7, node0).val);

	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		List<TreeNode> list1 = new ArrayList<TreeNode>();
		boolean[] found1 = new boolean[1];
        pathTreeNode(list1, root, p, found1);
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        boolean[] found2 = new boolean[1];
        pathTreeNode(list2, root, q, found2);
        List<TreeNode> list = new LinkedList<TreeNode>();
        List<TreeNode> len = list1.size() > list2.size() ? list1 : list2;
        for(int i = 0;i<len.size();i++) {
            TreeNode cur = len.get(i);
            if(list1.contains(cur) && list2.contains(cur)) {
                list.add(cur);
            }
        }
        return list.get(list.size() - 1);


    }

    public static void pathTreeNode(List<TreeNode> list, TreeNode root, TreeNode node, boolean[] found) {

        if(root == null) {
            return ;
        }
        if(root == node) {
            list.add(root);
            found[0] = true;
            return;
        }
        list.add(root);
        pathTreeNode(list, root.left, node, found);
        if(found[0]) {
        	return ;
        }
        pathTreeNode(list, root.right, node, found);
        if(found[0]) {
        	return ;
        }
        list.remove(list.size() - 1);
        
	}

}
