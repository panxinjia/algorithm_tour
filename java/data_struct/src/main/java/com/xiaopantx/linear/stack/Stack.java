package com.xiaopantx.linear.stack;

/**
 * @author xiaopantx
 */
public interface Stack<E> {

    E peek();

    E pop();

    void push(E e);

    int size();

    boolean isEmpty();

}
