package com.leetcode.SerializeAndDeserializeBST;

public class Codec3 {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
    	if(root == null) {
    		return "";
    	}
    	if(root.left == null && root.right == null) {
    		return "" + root.val;
    	}
    	String s = serialize(root.left);
    	s = "(" + s + ")" + "(" + root.val + ")";
    	s += "(" + serialize(root.right) + ")";
    	return s;
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	if(!data.contains("(") && !data.contains(")")) {
    		if(data.length() == 0) {
    			return null;
    		}else {
    			return new TreeNode(Integer.valueOf(data));
    		}
    	}
    	int count = 0;
    	int index = 0;
    	int start = 0;
    	while(index < data.length()) {
    		if(data.charAt(index) == '(') {
    			count ++;
    		}
    		if(data.charAt(index) == ')') {
    			count --;
    		}
    		if(count == 0) {
    			start = index;
    			break;
    		}
    		index ++;
    	}
    	start ++;
    	int temp = start + 1;
    	while(temp < data.length()) {
    		if(data.charAt(temp) == ')') {
    			break;
    		}
    		temp ++;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(data.substring(start + 1, temp)));
    	root.left = deserialize(data.substring(1, start - 1));
    	root.right = deserialize(data.substring(temp + 2, data.length() - 1));
    	return root;
    	
    }
    
}
