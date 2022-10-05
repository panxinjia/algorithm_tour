package com.xiaopantx.search;

/**
 * @author xiaopantx
 */
public class BinarySearch {

    private BinarySearch() {}

    // 二分查找, 非递归写法
    public static <E extends Comparable<E>> int search(E[] data, E key) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int l = 0, r = data.length - 1;
        int mid = (l + (r - l)) / 2;

        while (l <= r) {
            if (data[mid].compareTo(key) > 0) {

            }else if (data[mid].compareTo(key) < 0) {

            }else {
                return mid;
            }
        }

        return -1;
    }


    // 二分查找, 递归写法
    public static <E extends Comparable<E>> int searchR(E[] data, E key) {
        return -1;
    }
}
