package com.xiaopantx.linear.queue;

import com.xiaopantx.linear.array.Array;

/**
 *
 * 数组队列, 队列头尾操作, 至少有一头的操作复杂度是 O(n)
 * @author xiaopantx
 */
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> data;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        data = new Array<>(capacity);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front[");
        for (int i = 0; i < data.size(); i++) {
            res.append(data.get(i));
            if (i != data.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public void enQueue(E e) {
        data.addLast(e);
    }

    @Override
    public E deQueue() {
        return data.removeFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

}
