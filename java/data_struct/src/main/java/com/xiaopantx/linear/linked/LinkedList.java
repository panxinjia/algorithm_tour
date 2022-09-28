package com.xiaopantx.linear.linked;

/**
 * 链表:
 * <p>
 * 1. 真正的动态数据结构, 最简单的动态数据结构
 * 2. 天生的递归性质
 * 3. 深入理解引用 / 指针
 * <p>
 * 真正的动态, 不需要处理固定容量的问题, 但丧失了随机访问的能力.
 *
 * @author xiaopantx
 */
public class LinkedList<E> {

    // 链表头
    private Node head;

    // 链表中有多少个元素
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail, " +
                    "Require index >= 0 and index <= size");
        }

        if (index == 0) {
            addFirst(e);
        }else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur.e).append(" -> ");
        }
        res.append("NULL");
        return res.toString();
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

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
