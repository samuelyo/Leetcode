package com.leetcode.SubtreeofAnotherTree;

import java.util.ArrayList;
import java.util.List;

public class SubtreeofAnotherTree2 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(2);
		TreeNode t10 = new TreeNode(0);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t10;

		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(1);
		TreeNode t8 = new TreeNode(2);

		t6.left = t7;
		t6.right = t8;

		System.out.println(isSubtree(t1, t6));

	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null)
			return false;
		if (isSame(s, t))
			return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private static boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;

		//if(null == s || null == t){
		//   return s == t
		if (s.val != t.val)
			return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}

}
