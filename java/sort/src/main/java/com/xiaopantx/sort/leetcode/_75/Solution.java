package com.xiaopantx.sort.leetcode._75;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 思路: 三路快排中 partition 思路, 将元素快速分区
 *
 *      快速排序的思想
 *          应用一:
 *              解决排序问题
 *          应用二:
 *              解决 Select K 的问题, 找到一组元素中, 第K小的问题
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int l = -1;
        int i = 0;
        int r = nums.length;

        while (i < r) {
            if (nums[i] == 0) {
                l++;
                swap(nums, i, l);
                i++;
            }else if (nums[i] == 2) {
                r--;
                swap(nums, i, r);
            }else if (nums[i] == 1) {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        (new Solution()).sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}