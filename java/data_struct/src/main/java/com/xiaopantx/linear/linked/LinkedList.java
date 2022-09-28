package com.xiaopantx.linear.linked;

/**
 * 链表:
 *
 *  1. 真正的动态数据结构, 最简单的动态数据结构
 *  2. 天生的递归性质
 *  3. 深入理解引用 / 指针
 *
 *  真正的动态, 不需要处理固定容量的问题, 但丧失了随机访问的能力.
 *
 * @author xiaopantx
 */
public class LinkedList<E> {

    // 链表头
    private Node head;

    // 链表中有多少个元素
    private int size;

    public LinkedList() {

    }

    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }
}
