package com.wdq.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wudq
 * @date 2020/11/08
 */
public class _146_LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node first;
    private Node last;

    public _146_LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;

        first = new Node();
        last = new Node();
        first.next = last;
        last.pre = first;
    }

    public int get(int key) {
        Node v = map.get(key);
        if (v == null) return -1;
        //移除node
        removeNode(v);
        //插入链表头部
        addFirst(v);
        return v.value;
    }

    public void put(int key, int value) {
        Node v = map.get(key);
        //值不存在
        if (v == null) {
            v = new Node(key, value);
            //超出容量移除最后一个元素
            if (map.size() == capacity) {
                removeNode(map.remove(last.pre.key));
            }
            addFirst(v);
        //值存在
        } else {
            removeNode(v);
            addFirst(v);
            v.value = value;
        }
        map.put(key, v);
    }

    //插入头部
    private void addFirst(Node node) {
        node.next = first.next;
        node.next.pre = node;
        first.next = node;
        node.pre = first;

    }

    //移除元素
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    static class Node {
        public Integer key;
        public Integer value;
        public Node pre;
        public Node next;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        _146_LRUCache lRUCache = new _146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int i1 = lRUCache.get(1);// 返回 1
        System.out.println("i1 = " + i1);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        int i2 = lRUCache.get(2);// 返回 -1 (未找到)
        System.out.println("i2 = " + i2);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        int i3 = lRUCache.get(1);// 返回 -1 (未找到)
        System.out.println("i3 = " + i3);
        int i4 = lRUCache.get(3);// 返回 3
        System.out.println("i4 = " + i4);
        int i5 = lRUCache.get(4);// 返回 4
        System.out.println("i5 = " + i5);
    }
}


