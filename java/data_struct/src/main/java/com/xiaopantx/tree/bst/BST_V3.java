package com.xiaopantx.tree.bst;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树:
 * <p>
 * 树结构在计算机科学领域应用广泛, 需要非常数量的掌握
 * <p>
 * 满二叉树:   除叶子节点外, 每个节点都有两个孩子节点
 * 完全二叉树:
 * <p>
 * <p>
 * 二分搜索树:
 * 1. 二叉树
 * 2. 二分搜索数每个节点的值, 大于左子树所有节点, 小于右子树的所有节点
 * <p>
 * TODO 二分搜索树 常规方法的非递归写法
 * <p>
 * TODO 参考v2 版本, 实现一下链表中的添加方法 ( -> 比二叉树容易 )
 *  思考链式结构的递归过程, 什么是否有返回, 什么时候无返回, 链式结构的特征, 动态性, 引用.
 *
 * @author xiaopantx
 * <p>
 * 二分搜索树
 * 1. 中序遍历的结果是顺序排列的 (遵循二分搜索树的定义).
 * 2. 掌握二分搜索树遍历的简便方法 ( 什么时候可以访问, 什么时候具体进行访问 )
 *
 *
 * ->
 *      前序遍历的非递归实现
 *
 *     刻意关联知识点, 反复练习, 才能游刃有余,  DFS 和 BFS 在 树 和 图中都有广泛应用.
 */
public class BST_V3<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BST_V3() {
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
        } else if (e.compareTo(node.e) > 0) {
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
        } else if (e.compareTo(node.e) < 0) { // 在左子树上, 递归开始
            return contains(node.left, e);
        } else { // 在右子树上, 递归开始
            return contains(node.right, e);
        }
    }

    // 删除,  删除二分搜索树上的元素
    // 1.1 删除二分搜索树中的最小值和最大值

    //


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

    // --> 前序, 中序, 后序, 利用栈结构的深度优先遍历(DFS)
    // 前序遍历非递归写法
    public void preOrderNR() {
        //TODO  中序 和 后序的非递归写法, 用的不多, 但是可以练习一下
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // --> 广度优先遍历(BFS), 也叫层序遍历, 常见于算法设计中, 最短路径问题.
    public void levelOrder() {
        // 队列结构 -> 广度优先遍历, 常见于搜索策略, 更快的找到答案 ( 根据对问题解的估计, 更快找到解 )
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {

            Node node = queue.removeFirst();
            System.out.println(node.e);

            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
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

    // 后序遍历, 后序遍历, 先访问的是子节点, 可用于内存释放
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    // 字符串打印
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        // 前序遍历思路, 拼接字符串, 进行打印
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        BST_V3<Integer> bst = new BST_V3<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
    }
}
