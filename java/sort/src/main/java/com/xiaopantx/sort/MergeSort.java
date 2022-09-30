package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Arrays;

/**
 *
 * 归并排序
 *
 * 递归函数复杂度分析基本方法 -> 分析递归树
 *
 *  主定理 -> 参考<<算法导论>>
 *
 * @author xiaopantx
 * @version 1.0
 */
public class MergeSort {
    private MergeSort() {}

    public static <E extends Comparable<E>> void sort(E[] data) {
        sort(data, 0, data.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] data, int l, int r) {
        if (l >= r) {
            return;
        }
        // 索引越界问题 mid = (l + (r - l)) / 2
        int mid = (l + r) / 2;
        // 递归树的左半部分
        sort(data, l, mid);
        // 递归树的右半部分
        sort(data, mid + 1, r);
        // 完成归并
        merge(data, l, mid, r);
    }

    // 完成归并, 归并过程, 计算索引的偏移量要比较小心
    private static <E extends Comparable<E>> void merge(E[] data, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(data, l, r + 1);

        int i = l;      //  [l, mid]
        int j = mid + 1; // [mid + 1, r]
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                data[k] = temp[j - l];
                j++;
            }else if (j > r) {
                data[k] = temp[i - l];
                i++;
            }else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                data[k] = temp[i - l];
                i++;
            }else {
                data[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
//        Integer[] data = ArrayGenerator.generatorRandomArray(10, 10);
//        System.out.println("before sort: " + Arrays.toString(data));
//        MergeSort.sort(data, 0, data.length - 1);
//        System.out.println("after sort: " + Arrays.toString(data));
        int[] dataSize = {10_0000};
        for (int size: dataSize) {
            // 不同排序算法的对比, 复杂度层面对算法进行优化, 性能有明显的提升
            Integer[] data = ArrayGenerator.generatorRandomArray(size, size);
            Integer[] data2 = Arrays.copyOf(data,data.length);
            Integer[] data3 = Arrays.copyOf(data,data.length);
            SortHelper.sortTest(SortType.MERGE_SORT, data);
            SortHelper.sortTest(SortType.INSERTION_SORT, data2);
            SortHelper.sortTest(SortType.SELECTION_SORT, data3);
        }
    }
}
