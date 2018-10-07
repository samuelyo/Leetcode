package com.leetcode.CompleteBinaryTreeInserter;

import java.util.*;

public class CBTInserter {

    TreeNode temp;
    Map<Integer, TreeNode> map;
    List<TreeNode> list;
    int count = 0;

    public CBTInserter(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();
        temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                TreeNode node = queue.poll();
                count++;
                map.put(count, node);
                list.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        count++;
        map.put(count, node);
        int index = count / 2;
        TreeNode father = map.get(index);
        if (count % 2 == 0) {
            father.left = node;
        } else {
            father.right = node;
        }
        return father.val;
    }

    public TreeNode get_root() {
        return temp;
    }
}
