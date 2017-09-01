package com.leetcode.PrintBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
//		node3.left = node4;
		
		List<List<String>> res = printTree(node1);
		for(int i = 0;i<res.size();i++){
			List<String> cur = res.get(i);
			for(int j = 0;j<cur.size();j++){
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}
		
	}
	
	public static List<List<String>> printTree(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int height = heightOfTree(root);
		int listsize = 0;
		for(int i = 0;i<height;i++){
			listsize = 2 * listsize + 1;
		}
		List<List<Integer>> indexes = new ArrayList<List<Integer>>();
		for(int i = 0;i<height;i++){
			List<Integer> list = new ArrayList<Integer>();
			if(i == 0){
				for(int j = 0;j<listsize;j+=2){
					list.add(j);
				}
				indexes.add(list);
			}else{
				List<Integer> temp = indexes.get(indexes.size() - 1);
				for(int j = 0;j<temp.size();j+=2){
					list.add((temp.get(j) + temp.get(j+1)) / 2);
				}
				indexes.add(list);
			}
		}
		Collections.reverse(indexes);
		List<List<String>> res = new ArrayList<List<String>>();
		int curLevel = 0;
		queue.add(root);
		while(curLevel < height){
			List<Integer> indexList = indexes.get(curLevel);
			int num = (int) Math.pow(2, curLevel);
			List<String> cur = new ArrayList<String>();
			for(int i = 0;i<num;i++){
				TreeNode temp = queue.poll();
				int index = indexList.get(i);
				if(cur.size() < index){
					int diff = index - cur.size();
					for(int j = 0;j<diff;j++){
						cur.add("");
					}
				}
				if(temp != null){
					cur.add(temp.val + "");
				}else{
					cur.add("");
				}
				if(temp != null){
					queue.add(temp.left);
					queue.add(temp.right);
				}else{
					queue.add(null);
					queue.add(null);
				}
			}
			int diff = listsize - cur.size();
			for(int i = 0;i<diff;i++){
				cur.add("");
			}
			res.add(cur);
			curLevel ++;
		}
		return res;
		
	}
	
	public static int heightOfTree(TreeNode root) {
		
		if(root == null){
			return 0;
		}
		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
		
	}

}
