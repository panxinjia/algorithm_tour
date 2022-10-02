package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Random;

/**
 *
 * 快速排序算法
 *
 *  三路快速排序: 某些特殊的数据样本, 快速排序算法的时间复杂度为O(n)
 *
 * @author xiaopantx
 * @version 1.0
 */
public class QuickSort_V3 {

    private QuickSort_V3() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        Random rnd = new Random();
        sort(data, 0, data.length - 1, rnd);
    }

    public static <E extends Comparable<E>> void sort(E[] data, int l, int r, Random rnd) {
        if (l >= r)  {
            return;
        }

        int pivot = partition(data, l, r, rnd);
        sort(data, l, pivot - 1, rnd);
        sort(data, pivot + 1, r, rnd);
    }

    public static <E extends Comparable<E>> int partition(E[] data, int l, int r, Random rnd) {
        int pivot = rnd.nextInt(r - l + 1) + l;
        SortHelper.swap(data, pivot, l);

        int lt = l + 1;
        int gt = r;
        for (int i = 0; i < r; i++) {
            if (i >= gt) {
                break;
            }
            if (data[i].compareTo(data[l]) < 0) {
                // 扩充左半部分
            }

            if (data[i].compareTo(data[l]) > 0) {
                // 扩充右半部分
            }

            // data[i].compareTo(data[l]) == 0 -> 什么都不需要做
        }

        SortHelper.swap(data, l, lt);
        return lt;
    }

    public static void main(String[] args) {

    }

}
