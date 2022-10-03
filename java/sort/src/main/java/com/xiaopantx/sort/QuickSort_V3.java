package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序算法
 * <p>
 * 三路快速排序: 某些特殊的数据样本, 快速排序算法的时间复杂度为O(n)
 *
 * @author xiaopantx
 * @version 1.0
 */
public class QuickSort_V3 {

    private QuickSort_V3() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        Random rnd = new Random();
        sort(data, 0, data.length - 1, rnd);
    }

    public static <E extends Comparable<E>> void sort(E[] data, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }

        // 返回左区间右边界的索引位置和右区间左边界的索引位
        int[] pivots = partition(data, l, r, rnd);
        sort(data, l, pivots[0], rnd);
        sort(data, pivots[1], r, rnd);
    }

    // 标定点取 data[l] 元素
    public static <E extends Comparable<E>> int[] partition(E[] data, int l, int r, Random rnd) {
        int pivot = rnd.nextInt(r - l + 1) + l;
        SortHelper.swap(data, pivot, l);

        // 小于标定点的部分
        int lt = l;
        // 大于标定点的部分
        int gt = r + 1;
        for (int i = l + 1; i < gt; ) {
            if (data[i].compareTo(data[l]) < 0) {
                // 扩充左半部分
                lt++;
                SortHelper.swap(data, i, lt);
                i++;
            }

            else if (data[i].compareTo(data[l]) > 0) {
                // 扩充右半部分
                gt--;
                SortHelper.swap(data, i, gt);
            }

            else {
                // 等于标定点的元素, 执行i++
                i++;
            }
        }

        SortHelper.swap(data, l, lt);
        return new int[]{lt - 1, gt};
    }

    // TODO 用 while 循环实现一次三路快速排序
    public static <E extends Comparable<E>> int[] sort3Ways(E[] data, int l, int r, Random rnd) {
        return null;
    }

    public static void main(String[] args) {
//        Integer[] data = ArrayGenerator.generatorRandomArray(10, 10);
//        System.out.println("before sort = " + Arrays.toString(data));
//        QuickSort_V3.sort(data);
//        System.out.println("after sort = " + Arrays.toString(data));

        int n  = 1000_0000;
        System.out.println("Random Array: ");
        Integer[] data = ArrayGenerator.generatorRandomArray(n, n);
        Integer[] data2 = Arrays.copyOf(data, data.length);
        Integer[] data3 = Arrays.copyOf(data, data.length);

        SortHelper.sortTest(SortType.QUICK_SORT_V1, data);
        SortHelper.sortTest(SortType.QUICK_SORT_V2, data2);
        SortHelper.sortTest(SortType.QUICK_SORT_V3, data3);

        System.out.println("Ordered Array: ");
        data = ArrayGenerator.generatorOrderedArray(n);
        data2 = Arrays.copyOf(data, data.length);
        data3 = Arrays.copyOf(data, data.length);
        SortHelper.sortTest(SortType.QUICK_SORT_V1, data);
        SortHelper.sortTest(SortType.QUICK_SORT_V2, data2);
        SortHelper.sortTest(SortType.QUICK_SORT_V3, data3);

        System.out.println("Consts Array: ");
        data = ArrayGenerator.generatorRandomArray(n, 1);
        data2 = Arrays.copyOf(data, data.length);

//        对于单路快速排序, 完全有序的数组, 快速排序的时间复杂度会退化
//        data3 = Arrays.copyOf(data, data.length);
//        SortHelper.sortTest(SortType.QUICK_SORT_V1, data);
        SortHelper.sortTest(SortType.QUICK_SORT_V2, data);
        SortHelper.sortTest(SortType.QUICK_SORT_V3, data2);

    }

}
