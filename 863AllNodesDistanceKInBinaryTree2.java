package com.leetcode.AllNodesDistanceKInBinaryTree;

import java.util.*;

public class AllNodesDistanceKInBinaryTree2 {

    public static void main(String[] args) {

    }

    public static Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        buildMap(root, null);
        if (!map.containsKey(target)) {
            return res;
        }
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for (int k = 0; k < size; k++) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            for (int k = 0; k < size; k++) {
                TreeNode cur = queue.poll();
                List<TreeNode> list = map.get(cur);
                for (TreeNode node : list) {
                    if (!visited.contains(node)) {
                        queue.add(node);
                        visited.add(node);
                    }
                }
            }
            K --;
        }
        return res;
    }

    public static void buildMap(TreeNode child, TreeNode parent) {
        if (child == null) {
            return;
        }
        if (!map.containsKey(child)) {
            map.put(child, new ArrayList<>());
        }
        if (parent != null) {
            map.get(child).add(parent);
            map.get(parent).add(child);
        }
        buildMap(child.left, child);
        buildMap(child.right, child);
    }
}
