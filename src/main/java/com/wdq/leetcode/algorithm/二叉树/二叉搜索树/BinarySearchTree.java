package com.wdq.leetcode.algorithm.二叉树.二叉搜索树;

import com.wdq.leetcode.BinaryTreePrinter.src.com.mj.printer.BinaryTreeInfo;

/**
 * @author wudq
 * @date 2020/7/3
 */
public class BinarySearchTree<E extends Comparable<E>> implements BinaryTreeInfo {

    private int size;

    private Node root;

    public int size() {
        return size;
    }

    /**
     * 增
     * @param   element
     * @return
     */
    public boolean add(E element) {
        checkElement(element);
        if (root == null) {
            root = new Node(element, null);
            size++;
            return Boolean.TRUE;
        }
        Node node   = root;
        Node parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, (E) node.element);
            parent = node;
            //大 走右节点
            if (cmp > 0) {
                node = node.right;
            } else {//小 左节点
                node = node.left;
            }
        }
        //创建节点
        Node newNode = new Node(element, parent);
        //与父节点建立关系
        if (cmp > 0 ) {
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;
        return Boolean.TRUE;
    }

    /**
     * 删
     * @param element
     * @return
     */
    public boolean remove(E element) {
        return Boolean.FALSE;
    }

    /**
     * 是否包含
     * @param element
     * @return
     */
    public boolean contains(E element) {
        checkElement(element);
        if (root == null) {
            return Boolean.FALSE;
        }
        Node node = root;
        int cmp;
        while (node != null) {
            cmp = compare(element, (E) node.element);
            //大 走右节点
            if (cmp > 0) {
                node = node.right;
            } else if (cmp <0){//小 左节点
                node = node.left;
            }else if (element.equals(node.element)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    public E getMax() {
        return null;
    }

    public E getMin() {
        return null;
    }

    private void checkElement(E elemnet) {
        if (elemnet == null) {
            throw new IllegalArgumentException("节点不能为空");
        }
    }

    private int compare(E e1, E e2) {
      return e1.compareTo(e2);
    }

    /**
     * 节点
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent  =  parent;
        }
    }

    /********** BinaryTreeInfo **********/
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node)node).element;
    }
    /********** BinaryTreeInfo **********/
}
