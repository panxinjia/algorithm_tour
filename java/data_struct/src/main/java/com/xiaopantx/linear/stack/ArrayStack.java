package com.xiaopantx.linear.stack;

import com.xiaopantx.linear.array.Array;

/**
 * 栈: 线性数据结构, 动态数组操作的子集
 * @author xiaopantx
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack() {
        this(10);
    }
    public  ArrayStack(int capacity) {
        data = new Array<>(capacity);
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < data.size(); i++) {
            res.append(data.get(i));
            if (i != data.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
