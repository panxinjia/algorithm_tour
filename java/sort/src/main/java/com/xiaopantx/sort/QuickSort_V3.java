package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Random;

/**
 *
 * 快速排序算法
 *
 *  双路快速排序
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
        // 引入随机算法
        int pivot = rnd.nextInt(r - l + 1) + l;
        SortHelper.swap(data, l, pivot);

        int j = l;
        // [l + 1, j] 小于v, [j + 1, i - 1] 大于v
        for (int i = l + 1; i <= r; i++) {
            if (data[i].compareTo(data[l]) < 0) {
                j++;
                // 第一个元素如果就要完成交换, 处理的是元素自身
                SortHelper.swap(data, j, i);
            }else {
                // 元素大于标定点元素, 什么都不需要做, 继续整理剩余元素即可
            }
        }
        // 将标定元素交换到对应的位置上
        SortHelper.swap(data, l, j);
        return j;
    }

    public static void main(String[] args) {

        int n = 50000;
//        引入随机化, 解决有序数组导致快排退化的问题
        Integer[] data = ArrayGenerator.generatorOrderedArray(n);
        SortHelper.sortTest(SortType.QUICK_SORT_V1, data);

//        Integer[] data = ArrayGenerator.generatorRandomArray(n, 1);
//        SortHelper.sortTest(SortType.QUICK_SORT_V1, data);
    }



}
