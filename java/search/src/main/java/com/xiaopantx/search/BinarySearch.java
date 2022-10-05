package com.xiaopantx.search;

import com.xiaopantx.common.ArrayGenerator;

/**
 * @author xiaopantx
 */
public class BinarySearch {

    private BinarySearch() {}

    // 二分查找, 非递归写法, 元素不存在时返回 -1
    public static <E extends Comparable<E>> int search(E[] data, E key) {
        if (data == null || data.length == 0) {
            return -1;
        }

        int l = 0, r = data.length - 1;

        // 充分理解循环不变量的定义
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(key) > 0) {
                r = mid - 1;
            }else if (data[mid].compareTo(key) < 0) {
                l = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }


    // 二分查找, 递归写法
    public static <E extends Comparable<E>> int searchR(E[] data, E key) {
        return searchR(data, 0, data.length - 1, key);
    }

    public static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E key) {
        if (data == null || data.length == 0 || l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(key) > 0) {
            // 左半部分
            return searchR(data, l, mid - 1, key);
        }else if (data[mid].compareTo(key) < 0){
            // 右半部分
            return searchR(data, mid + 1, r, key);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generatorOrderedArray(100_0000);
        int res = BinarySearch.searchR(data,-2);
        System.out.println("res = " + res);
    }
}
