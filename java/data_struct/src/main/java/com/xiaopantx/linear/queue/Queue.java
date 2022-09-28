package com.xiaopantx.linear.queue;

/**
 * 队列接口
 * @author xiaopantx
 */
public interface Queue<E> {

    // 查看队首元素
    E getFront();

    // 从队尾入队一个元素
    void enQueue(E e);

    // 队首出队元素怒
    E deQueue();

    // 队列中元素的个数
    int size();

    // 队列是否为空
    boolean isEmpty();

}
