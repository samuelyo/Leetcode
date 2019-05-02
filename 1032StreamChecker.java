package com.leetcode.StreamOfCharacters;

public class StreamChecker {
    public class TriNode { /*Tri树节点*/
        boolean isend = false;
        TriNode[] next = new TriNode[26];
    }

    TriNode root = new TriNode();  /*Tri树初始化*/
    StringBuilder buf = new StringBuilder(); /*用来存储流数据*/

    void insert(String word) { /*Tri树插入单词*/
        TriNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(word.length() - 1 - i);
            if (tmp.next[ch - 'a'] == null) {
                tmp.next[ch - 'a'] = new TriNode();
            }
            tmp = tmp.next[ch - 'a'];
        }
        tmp.isend = true;
    }

    public StreamChecker(String[] words) { /*构造Tri树*/
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) { /*查询流末端是否有指定单词*/
        buf.insert(0, letter);
        TriNode p = root;
        for (char ch : buf.toString().toCharArray()) {
            p = p.next[ch - 'a'];
            if (p == null) {
                return false;
            }
            if (p.isend == true) {
                return true;
            }
        }
        return false;
    }
}
