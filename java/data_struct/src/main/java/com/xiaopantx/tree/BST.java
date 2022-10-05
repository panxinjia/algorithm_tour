package com.xiaopantx.tree;

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
