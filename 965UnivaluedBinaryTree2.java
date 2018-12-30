package com.leetcode.UnivaluedBinaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UnivaluedBinaryTree2 {
    public static void main(String[] args) {

    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (!isUnivalTree(root.left))
                return false;
            if (root.left.val != root.val)
                return false;
        }

        if (root.right != null) {
            if (!isUnivalTree(root.right))
                return false;
            if (root.right.val != root.val)
                return false;
        }
        return true;
    }
}
