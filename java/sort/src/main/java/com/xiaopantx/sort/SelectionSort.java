package com.xiaopantx.sort;

import com.xiaopantx.common.ArrayGenerator;

import java.util.Arrays;

/**
 * @author xiaopantx
 */
public class SelectionSort {

    private SelectionSort() {}

    public static void sort(int[] data) {
        if (data == null || data.length < 2)
            return;

        int N = data.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            SortHelper.swap(data, i, minIndex);
        }
    }

    public static void sortR(int[] data) {
        if (data == null || data.length < 2)
            return;
        int N = data.length;
        for (int i = N - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] > data[maxIndex]) {
                    maxIndex = j;
                }
            }
            SortHelper.swap(data, i, maxIndex);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data == null || data.length < 2)
            return;

        int N = data.length;
        // 循环不变量 [0, i) 已排序, [i, n) 未排序
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortHelper.swap(data, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sortR(E[] data) {
        if (data == null || data.length < 2)
            return;
        int N = data.length;
        // 循环不变量 [i, n) 已排序, [0, i) 未排序, 定义清楚循环不变量, 更容易写出正确代码.
        for (int i = N - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >=0 ; j--) {
                if (data[j].compareTo(data[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            SortHelper.swap(data, i, maxIndex);
        }
    }

    public static void main(String[] args) {

//        测试选择排序
//        int[] data = {10, 9, 1, 3, 22};
//        System.out.println("before sort: " + Arrays.toString(data));
//        SelectionSort.sort(data);
//        SelectionSort.sortR(data);
//        System.out.println("after sort: " + Arrays.toString(data));

//        测试泛型选择排序
//        Integer[] data = ArrayGenerator.generatorRandomArray(100, 100);
//        System.out.println("before sort: " + Arrays.toString(data));
//        SelectionSort.sort(data);
//        SelectionSort.sortR(data);
//        System.out.println("after sort: " + Arrays.toString(data));

//        自定义类型的排序
//        Student[] students = {
//                new Student("jack", 89),
//                new Student("tom", 100),
//                new Student("tomas", 72)
//        };
//
//        System.out.println("before sort: " + Arrays.toString(students));
//        SelectionSort.sort(students);
//        boolean isSorted = SortHelper.isSorted(students);
//        if (!isSorted)
//            throw new RuntimeException("排序失败");
//
//        System.out.println("after sort: " + Arrays.toString(students));


//        选择排序算法时间复杂度测试, 选择排序的时间复杂度 n^2
        int[] dataSize = {10000, 100000};
        for (int size: dataSize) {
            Integer[] data = ArrayGenerator.generatorRandomArray(size, size);
            SortHelper.sortTest(SortType.SELECTION_SORT, data);
        }

    }

}
