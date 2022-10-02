package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * 快速排序算法
 *
 *  双路快速排序
 *      1. 随机化
 *      2. 解决相同元素的数据样本导致的性能退化问题
 *
 * @author xiaopantx
 * @version 1.0
 */
public class QuickSort_V2 {

    private QuickSort_V2() {}

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

    // 双路快速排序
    public static <E extends Comparable<E>> int partition(E[] data, int l, int r, Random rnd) {
        //引入随机化
        int pivot = rnd.nextInt(r - l + 1) + l;
        SortHelper.swap(data, l, pivot);

        int  j = r;
        int  i = l + 1;
        while (true) {
            // 扩充左半部分
            while (i < j && data[i].compareTo(data[l]) < 0) {
                i++;
                System.out.println("left: i = " + i);
            }

            // 扩充右半部分
            while (j > i && data[j].compareTo(data[l]) > 0) {
                j--;
                System.out.println("right: j = " + j);
            }

            // i 和 j 都停下时, 交换左右分区的元素, 移动边界点.
            SortHelper.swap(data, i, j);
            i++;
            j--;

            // 数组遍历完成, 退出循环
            if ( i >= j ) {
                break;
            }
        }

        SortHelper.swap(data, l, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generatorRandomArray(10, 1);
        System.out.println("before sort: " + Arrays.toString(data));
        QuickSort_V2.sort(data);
        System.out.println("after sort: " + Arrays.toString(data));
    }



}
