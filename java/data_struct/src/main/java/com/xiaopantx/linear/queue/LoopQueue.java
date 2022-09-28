package com.xiaopantx.linear.queue;

import java.util.NoSuchElementException;

/**
 * 循环队列:  front == tail -> 队列为空,  (tail + 1) % data.length == front -> 队列为满
 *      解决数组队列其中一端操作时间复杂度为O(n)的情况
 *      环型数据结构同理
 *
 * 注意 resize() 和 toString() 两种不同遍历循环队列的方式
 *
 * @author xiaopantx
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        return data[front];
    }

    // 入队操作
    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(capacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    // 出队操作
    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == capacity() / 4 && capacity() / 2 != 0) {
            resize(capacity() / 2);
        }
        return ret;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int capacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d, front = %d, tail = %d\n",
                size, capacity(), front, tail));
        res.append("front [");

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if (i % data.length != tail - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    // 扩缩容, 将循环队列中原来的元素拷贝到新数组中
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 计算便宜量
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
