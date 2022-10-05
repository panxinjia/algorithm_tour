package com.xiaopantx.tree.bst;

/**
 *  二叉树:
 *
 *  树结构在计算机科学领域应用广泛, 需要非常数量的掌握
 *
 *  满二叉树:   除叶子节点外, 每个节点都有两个孩子节点
 *  完全二叉树:
 *
 *
 *  二分搜索树:
 *      1. 二叉树
 *      2. 二分搜索数每个节点的值, 大于左子树所有节点, 小于右子树的所有节点
 *
 * TODO 二分搜索树非递归写法
 * @author xiaopantx
 *
 */
public class BST<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }else {
            add(root, e);
        }
    }

    // 向以node为根的二分搜索树中插入元素e, 递归写法
    private void add(Node node, E e) {
        if (e.compareTo(node.e) == 0) {
            // 等值, 什么都不做, 这个BST定义, 不支持添加重复元素
        }else if (e.compareTo(node.e) > 0 && node.right == null) {
            // 添加到右孩子
            node.right = new Node(e);
            size++;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            // 添加到左孩子
            node.left = new Node(e);
            size++;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        }else {
            add(node.right,e);
        }
    }


    // 修改

    // 删除


    // 前序遍历
    public void preOrder() {}

    // 中序遍历

    // 后序遍历


    // 字符串打印
    @Override
    public String toString() {
        // TODO
        StringBuilder res = new StringBuilder();
        return res.toString();
    }



    private class Node {
        public Node left;

        public E e;
        public Node right;

        public Node(E e) {
            this(null, e, null);
        }

        public Node(Node left, E e, Node right) {
            this.left = left;
            this.e = e;
            this.right = right;
        }
    }
}
