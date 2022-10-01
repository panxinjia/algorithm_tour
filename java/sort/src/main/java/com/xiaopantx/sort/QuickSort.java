package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序算法
 * 1. 单路快排
 * 快速排序的缺点, 对于有序数组, 单路快排, 性能退化, 而且容易因为递归, 导致栈溢出.
 * 2. 双路快排
 * 3. 三路快排
 * <p>
 * <p>
 * 编码思想:
 * 1. 标定点, 范围扩充, 索引值定义
 * <p>
 * pivot position
 *
 * @author xiaopantx
 * @version 1.0
 */
public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        sort(data, 0, data.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] data, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = partition(data, l, r);
        sort(data, l, pivot - 1);
        sort(data, pivot + 1, r);
    }

    public static <E extends Comparable<E>> int partition(E[] data, int l, int r) {
        int pivot = l;
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (data[i].compareTo(data[pivot]) < 0) {
                j++;
                // 第一个元素如果就要完成交换, 处理的是元素自身
                SortHelper.swap(data, j, i);
            } else {
                // 元素大于标定点元素, 什么都不需要做, 继续整理剩余元素即可
            }
        }
        // 将标定元素交换到对应的位置上
        SortHelper.swap(data, pivot, j);
        return j;
    }

    public static void main(String[] args) {
//        Integer[] data = ArrayGenerator.generatorRandomArray(50000, 50000);
//        有序数组, 单路快排, 算法时间复杂度会退化
        Integer[] data = ArrayGenerator.generatorOrderedArray(50000);
        SortHelper.sortTest(SortType.QUICK_SORT, data);


//        int[] dataSize = {100000, 1000000};
//        for (int size: dataSize) {
//            Integer[] data = ArrayGenerator.generatorRandomArray(size, size);
//            Integer[] data2 = Arrays.copyOf(data, data.length);
//            Integer[] data3 = Arrays.copyOf(data, data.length);
//            SortHelper.sortTest(SortType.MERGE_SORT, data);
//            SortHelper.sortTest(SortType.QUICK_SORT, data2);
//            // 非常慢, 不可忍受
//            // SortHelper.sortTest(SortType.INSERTION_SORT_V3, data3);
//        }

    }


}
