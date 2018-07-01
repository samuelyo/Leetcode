package com.leetcode.AllNodesDistanceKInBinaryTree;

import java.util.*;

public class AllNodesDistanceKInBinaryTree3 {

    public static void main(String[] args) {

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(root, map);
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
            K--;
        }
        return res;
    }

    public static void buildMap(TreeNode root, Map<TreeNode, List<TreeNode>> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                TreeNode cur = queue.poll();
                if (!map.containsKey(cur)) {
                    map.put(cur, new ArrayList<>());
                }
                if (cur.left != null) {
                    if (!map.containsKey(cur.left)) {
                        map.put(cur.left, new ArrayList<>());
                    }
                    map.get(cur).add(cur.left);
                    map.get(cur.left).add(cur);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    if (!map.containsKey(cur.right)) {
                        map.put(cur.right, new ArrayList<>());
                    }
                    map.get(cur).add(cur.right);
                    map.get(cur.right).add(cur);
                    queue.offer(cur.right);
                }
            }
        }
    }
}
