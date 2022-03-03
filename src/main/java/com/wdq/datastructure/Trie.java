package com.wdq.datastructure;

/**
 * <description>IBM全球有35万员工，名字由26个字母组成，长度不一。请设计一个算法，能够快速查找出要查询的名字</description>
 * 字典树
 * @author wudq
 * @date 2022/03/03
 */
public class Trie {
    // root
    private final Node root;

    public Trie() {
        this.root = new Node();
    }

    /**
     * 添加
     * @param word
     */
    public void add(String word) {
        Node pNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node[] child = pNode.child;
            int index = word.charAt(i) - 'a';
            // 没找到，添加
            if (child[index] == null) {
                Node node = new Node();
                child[index] = node;
            } else {
                child[index].num++;
            }
            // 最后一个字符，isWord = true
            if (i == word.length() - 1) {
                child[index].isWord = true;
            }
            pNode = child[index];
        }
    }

    /**
     * 搜索
     * @param word word
     * @return
     */
    public boolean search(String word) {
        Node pNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node[] child = pNode.child;
            int index = word.charAt(i) - 'a';
            // index处无节点，表示不存在返回false
            if (child[index] == null) {
                return false;
            }
            // 是否是最后一个字符
            if (i == word.length() - 1) {
                return child[index].isWord;
            }
            pNode = child[index];
        }
        return false;
    }

    /**
     * 删除
     * @param word
     */
    public void del(String word) {
        Node pNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node[] child = pNode.child;
            int index = word.charAt(i) - 'a';
            Node node = child[index];
            if (node == null) {
                return;
            }
            // 是否是最后一个字符
            if (i == word.length() - 1) {
                node.isWord = false;
            }
            if (--node.num == 0) {
                child[index] = null;
            }
            pNode = node;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("jack");
        trie.add("tom");
        trie.add("rose");
        trie.add("brant");
        trie.add("branta");
        trie.add("american");
        boolean search = trie.search("brant");
        System.out.println("search = " + search);
        // del
        trie.del("brant");

        search = trie.search("brant");
        System.out.println("search = " + search);
        search = trie.search("branta");
        System.out.println("search = " + search);
    }
}

class Node {
    // 记录出现次数，删除会用到
    int num = 1;
    // 标识是否是单词最后一个字符
    boolean isWord = false;
    // 子节点，最多26个字符
    Node[] child = new Node[26];
}
