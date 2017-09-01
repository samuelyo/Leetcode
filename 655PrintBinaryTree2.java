package com.leetcode.PrintBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintBinaryTree2 {

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		// TreeNode node5 = new TreeNode(5);
		// TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);

		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		// node3.left = node4;

		List<List<String>> res = printTree(node1);
		for (int i = 0; i < res.size(); i++) {
			List<String> cur = res.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<String>> printTree(TreeNode root) {

		List<List<String>> res = new LinkedList<>();
		int height = root == null ? 1 : getHeight(root);
		int rows = height, columns = (int) (Math.pow(2, height) - 1);
		List<String> row = new ArrayList<>();
		for (int i = 0; i < columns; i++)
			row.add("");
		for (int i = 0; i < rows; i++)
			res.add(new ArrayList<>(row));
		populateRes(root, res, 0, rows, 0, columns - 1);
		return res;
		
	}

	public static void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
		
		if (row == totalRows || root == null)
			return;
		res.get(row).set((i + j) / 2, Integer.toString(root.val));
		populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
		populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
		
	}

	public static int getHeight(TreeNode root) {
		
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));

	}

}
