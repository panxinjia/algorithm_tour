package com.xiaopantx.linear.array;

import com.sun.org.apache.bcel.internal.generic.RET;

import javax.xml.crypto.Data;

/**
 * 动态数组
 *
 *      1. 线性结构数组操作的方法
 *      2. 实现扩缩容的方式
 *      3. 均摊复杂度 和 防止复杂度震荡
 * @author xiaopantx
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array() {
        // 默认构造函数
        this(10);
    }
    public Array(int capacity) {
        // 按照指定容量进行初始化
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (size == data.length) {
            // throw new IllegalArgumentException("Add failed, Array is full");
            // size == data.length -> 容器满时进行扩容
            resize(data.length * 2);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Require index >= 0 and index < size");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Require index >= 0 and index < size");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Require index >= 0 and index < index");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 引用类型 游离对象 != 内存泄露, 最好加上置空操作
        data[size - 1] = null;
        size--;

        // 元素数量达到容量的1/4时, 缩容一半, 并不是达到1/2时缩容一般, 防止添加和删除操作可能出现的复杂度震荡
        // 重要**
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 移除指定的元素时, 调用方已经知道要移除的元素是什么, 不必在返回值重新给出
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 删除所有的元素e, 返回删除元素的个数
    public int removeAllElements(E e) {
        int number = elementsNumber(e);
        if (number > 0) {
            // 删除所有的e元素
            E[] newData = (E[])new Object[data.length];
            for (int i = 0, k = 0; i < size; i++) {
                if (data[i].equals(e)) {
                    continue;
                }else {
                    newData[k] = data[i];
                    k++;
                }
            }
            // 替换掉原来的数组
            data = newData;
            size -= number;

            if (size == data.length / 4 && data.length / 2 != 0) {
                resize(data.length / 2);
            }
        }
        return number;
    }

    private int elementsNumber(E e) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                count++;
            }
        }
        return count;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
