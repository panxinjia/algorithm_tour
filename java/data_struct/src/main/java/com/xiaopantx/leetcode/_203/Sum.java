package com.xiaopantx.leetcode._203;

/**
 * 递归: 求解最基本的问题, 原问题转化为更小的问题
 *
 * 核心问题: 弄清楚递归函数的宏观语义.
 *
 * 1. 问题分解, 递推公式
 * 2. 递归函数的参数 ( 变化的量 )
 *
 * @author xiaopantx
 * @version 1.0
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        // 基本问题拆解: 基础元素 + 数组其它元素的和.
        return arr[l] + sum(arr,  l + 1);
    }

    public static void main(String[] args) {
        int[] data = {1,3,4,2,8};
        int sum = sum(data);
        System.out.println("sum = " + sum);
    }
}
