package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 插入排序特性: 不同的数据样本, 插入排序的时间复杂度会有不同, 对于有序的数据样本, 插入排序是线性复杂度.
 *
 * 插入排序的进阶版本:
 *      希尔排序, 认识算法的超参数, 数据样本
 * @author xiaopantx
 */
public class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int N = data.length;

        // 循环不变量 -> [0, i) 已排序, [i, N) 未排序, 维持循环, [0, N) 已排序时循环结束.
        for ( int i = 0; i < N; i++) {
            // 插入排序法内循环的索引变化, pre, cur 相对位置容易犯错.
            for(int cur = i, pre = cur - 1; pre >= 0 && data[pre].compareTo(data[cur]) > 0; pre--, cur--) {
                SortHelper.swap(data, pre, cur);
            }
        }
    }

    // 插入排序法的一个优化
    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        int N = data.length;
        for (int i = 0; i < N; i++) {
            E tmp = data[i];
            int j;
            for (j = i; j - 1 >= 0 && tmp.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = tmp;
        }
    }

    // 尾部开始执行的插入排序, 循环不变量[0, i)未排序, [i, N) 已排序
    public static <E extends Comparable<E>> void sort3(E[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int N = data.length;
        for (int i = N - 1; i >= 0; i--) {
            E tmp = data[i];
            int j;
            for (j = i; j + 1 < N && tmp.compareTo(data[j + 1]) > 0; j++) {
                data[j] = data[j + 1];
            }
            data[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generatorRandomArray(10, 10);
        System.out.println("before sort: " + Arrays.toString(data));
        InsertionSort.sort3(data);
        System.out.println("after sort: " + Arrays.toString(data));
//        int[] dataSize = {10000, 100000};
//        for (int size: dataSize) {
//            Integer[] data = ArrayGenerator.generatorRandomArray(size, size);
//            Integer[] copy = Arrays.copyOf(data, data.length);
//            SortHelper.sortTest(SortType.INSERTION_SORT, data);
//            SortHelper.sortTest(SortType.SELECTION_SORT, copy);
//        }

//        int[] dataSize = {10000, 100000};
//        for (int size: dataSize) {
//            System.out.println("Random Array: ");
//            Integer[] data1 = ArrayGenerator.generatorRandomArray(size, size);
//            Integer[] copy1 = Arrays.copyOf(data1, data1.length);
//            SortHelper.sortTest(SortType.INSERTION_SORT_V2, data1);
//            SortHelper.sortTest(SortType.SELECTION_SORT, copy1);
//
//            System.out.println("Ordered Array: ");
//            Integer[] data2 = ArrayGenerator.generatorOrderedArray(size);
//            Integer[] copy2 = Arrays.copyOf(data2, data2.length);
//            SortHelper.sortTest(SortType.INSERTION_SORT_V2, data2);
//            SortHelper.sortTest(SortType.SELECTION_SORT, copy2);
//        }
    }
}
