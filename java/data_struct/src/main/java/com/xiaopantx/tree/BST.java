package com.xiaopantx.tree;

/**
 * 二分搜索树 -> 最基本的树形结构
 *
 *  树结构在计算机科学领域应用广泛, 需要非常数量的掌握
 *
 * @author xiaopantx
 */
public class BST<E> {


    public BST() {}



    private class Node {
        public Node left;
        public E data;
        public Node right;

        public Node(E data) {
            this(null, data, null);
        }

        public Node(Node left, E data, Node right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }
}
