package com.leetcode.SerializeAndDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
    	int height = heightOfTree(root);
    	List<Integer> res = new ArrayList<Integer>();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int level = 1;
    	while(!queue.isEmpty()){
    		if(level > height){
    			break;
    		}
    		for(int i = 0;i<Math.pow(2, level - 1);i++){
    			TreeNode cur = queue.poll();
    			if(cur != null){
    				res.add(cur.val);
    			}else{
    				res.add(null);
    			}
        		if(cur != null){
        			queue.add(cur.left);
        			queue.add(cur.right);
        		}else{
        			queue.add(null);
        			queue.add(null);
        		}
    		}
    		level ++;
    	}
    	int index = res.size() - 1;
    	while(index > 0 && res.get(index) == null){
    		index --;
    	}
    	res = res.subList(0, index + 1);
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i<res.size();i++){
    		if(i != res.size() - 1){
    			sb.append(res.get(i) + " ");
    		}else{
    			sb.append(res.get(i));
    		}
    	}
    	return sb.toString();
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	if(data.equals("")){
    		return null;
    	}
    	String[] vals = data.split(" ");
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	for(int i = 0;i<vals.length;i++){
    		if(!vals[i].equals("null")){
    			TreeNode node = new TreeNode(Integer.valueOf(vals[i]));
    			list.add(node);
    		}else{
    			list.add(null);
    		}
    	}
    	for(int i = 0;i<list.size();i++){
    		if(2 * i + 1 < list.size() && list.get(i) != null) {
    			list.get(i).left = list.get(2 * i + 1);
    		}
    		if(2 * i + 2 < list.size() && list.get(i) != null){
    			list.get(i).right = list.get(2 * i + 2);
    		}
    		
    	}
    	return list.get(0);
    	
    }
    
    public int heightOfTree(TreeNode root) {
    	
    	if(root == null){
    		return 0;
    	}
    	return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    	
    }
    
}
