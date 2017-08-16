package com.leetcode.ImplementTriePrefixTree;

public class Trie {

	class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
		public boolean isEnd;
	}
	
	private TrieNode root ;
	
	 /** Initialize your data structure here. */
    public Trie() {
        
    	root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
    	TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
			node.isWord = true;
		}
		node.isEnd = true;
		
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
    	return matchSearch(word.toCharArray(), 0, root);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    	return matchStart(prefix.toCharArray(), 0, root);
    }
    
    public boolean matchSearch(char[] chs, int k, TrieNode node) {
    	
    	if (k == chs.length) {
			return node.isEnd;
		}
    	
    	return node.children[chs[k] - 'a'] != null && matchSearch(chs, k + 1, node.children[chs[k] - 'a']);
    }
    
    public boolean matchStart(char[] chs, int k, TrieNode node) {
    	
    	if (k == chs.length) {
			return node.isWord;
		}
    	
    	return node.children[chs[k] - 'a'] != null && matchStart(chs, k + 1, node.children[chs[k] - 'a']);
    }
}
