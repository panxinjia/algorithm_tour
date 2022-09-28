package com.xiaopantx.search;

import com.xiaopantx.common.ArrayGenerator;

/**
 * @author xiaopantx
 */
public class LinearSearch {

    private LinearSearch() {
        // 工具性质的类, 应当设计是单例的.
    }

    public static <E> int search(/*输入*/ E[] data, E target) {
        // 边界
        if (data == null || data.length == 0) {
            // 边界输出
            return -1;
        }

        // 查找过程
        for (int index = 0; index < data.length; index++) {
            if (data[index].equals(target)) {
                // 输出, 快速返回结果
                return index;
            }
        }
        // 输出
        return -1;
    }

    public static void main(String[] args) {
//        Integer[] data = {10, 9, 3, 1, 22, 4, 99};
//        int index = LinearSearch.search(data, 1);
//        System.out.println("index = " + index);
//
//        index = LinearSearch.search(data, 20);
//        System.out.println("index = " + index);
//
//        index = LinearSearch.search(null, 1);
//        System.out.println("index = " + index);
//
//        Student[] students = {new Student("Alice"),
//        new Student("jack"),
//        new Student("tom")};
//
//        // 对象的相等逻辑判断
//        index = LinearSearch.search(students, new Student("jack"));
//        System.out.println("index = " + index);

//        线性查找法算法复杂度测试, 线性复杂度 O(n)
        int[] dataSize = {100000, 1000000, 10000000};
        for (int size: dataSize) {
            Integer[] data = ArrayGenerator.generatorOrderedArray(size);
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                LinearSearch.search(data, size);
            long endTime = System.nanoTime();
            double costTime = (endTime - startTime) / 1000000000.0;
            System.out.println("规模size = " + size + ", 运行100次耗时 " + costTime + " s");

        }
    }
}
