package com.xiaopantx.common;

import java.util.Random;

/**
 * @author xiaopantx
 */
public class ArrayGenerator {

    private static final Random RANDOM = new Random();

    private ArrayGenerator() {}

    /**
     * 生成有序数组
     */
    public static Integer[] generatorOrderedArray(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        return data;
    }

    /**
     * 生成随机数组
     * @param n 规模
     * @param bound 上边界
     * @return 数组
     */
    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = RANDOM.nextInt(bound);
        }
        return data;
    }
}
