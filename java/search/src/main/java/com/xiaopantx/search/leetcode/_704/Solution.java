package com.xiaopantx.search.leetcode._704;

/**
 * leetcode 704号问题, 二分查找算法
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            }else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    private int search(int[] nums, int l, int r, int target) {
        if (nums == null || nums.length == 0 || l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (nums[mid] > target) {
            return search(nums, 0, mid - 1, target);
        }

        if (nums[mid] < target) {
            return search(nums, mid + 1, r, target);
        }
        return mid;
    }
}