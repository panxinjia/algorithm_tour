package com.xiaopantx.sort;

/**
 * @author xiaopantx
 */
public class SortHelper {

    private SortHelper() {

    }

    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(SortType type, E[] data) {
        long startTime = System.nanoTime();
        switch (type) {
            case SELECTION_SORT:
                SelectionSort.sort(data);
                break;
            case INSERTION_SORT:
                InsertionSort.sort(data);
                break;
            case INSERTION_SORT_V2:
                InsertionSort.sort2(data);
                break;
            case INSERTION_SORT_V3:
                InsertionSort.sort3(data);
                break;
            case MERGE_SORT:
                MergeSort.sort(data);
                break;
            case QUICK_SORT:
                QuickSort.sort(data);
                break;
            case QUICK_SORT_V1:
                QuickSort_V1.sort(data);
                break;
            default:
                // nothing
        }
        long endTime = System.nanoTime();
        double costTime = (endTime - startTime) / 1000000000.0;
        if (!SortHelper.isSorted(data)) {
            throw new RuntimeException("排序失败");
        }

        System.out.println(type.getName() + "-> 规模: " + data.length + ", 耗时: " + costTime + " s");
    }

    public static void swap(int[] data, int m, int n) {
        int tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }

    public static <E> void swap(E[] data, int m, int n) {
        E tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }
}
