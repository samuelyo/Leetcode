package com.leetcode.VerifyPreorderSerializationOfABinaryTree;

public class VerifyPreorderSerializationOfABinaryTree2 {

	public static void main(String[] args) {

		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(preorder));

	}

	public static boolean isValidSerialization(String preorder) {

		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node : nodes) {
			if (--diff < 0)
				return false;
			if (!node.equals("#"))
				diff += 2;
		}
		return diff == 0;
	}

}
