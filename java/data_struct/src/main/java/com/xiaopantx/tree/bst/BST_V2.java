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
 * TODO 二分搜索树 常规方法的非递归写法
 *
 * TODO 参考v2 版本, 实现一下链表中的添加方法 ( -> 比二叉树容易 )
 *  思考链式结构的递归过程, 什么是否有返回, 什么时候无返回, 链式结构的特征, 动态性, 引用.
 *
 * @author xiaopantx
 *
 *  二分搜索树
 *      1. 中序遍历的结果是顺序排列的 (遵循二分搜索树的定义).
 *
 *
 */
public class BST_V2<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BST_V2() {
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
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e, 并返回根节点
    //
    // 递归方法的宏观语义发生变化, 代码的写法写不同, 定义好宏观语义, 是写出
    // 正确代码的前提. (将 NULL 也看做是一个二叉树, 只是根节点也为NULL)
    private Node add(Node node, E e) {
        // 递归终止条件
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    // 查询元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 以node为根的二分搜索树, 是否包含元素 e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) { // 找到元素, 包含
            return true;
        }else if (e.compareTo(node.e) < 0) { // 在左子树上, 递归开始
            return contains(node.left, e);
        }else { // 在右子树上, 递归开始
            return contains(node.right, e);
        }
    }


    // 修改

    // 删除


    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历, 中序遍历的结果 -> 排序之后的顺序 ( 深刻的认识 )
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        // 递归结束
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后序遍历


    // 字符串打印
    @Override
    public String toString() {
        // TODO
        StringBuilder res = new StringBuilder();
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        // TODO
    }

    private String generateDepthString(int depth) {
        return "";
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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        BST_V2<Integer> bst = new BST_V2<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num: nums) {
            bst.add(num);
        }

        // bst.preOrder();
        bst.inOrder();
    }
}
