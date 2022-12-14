package com.xiaopantx.leetcode._203;

/**
 *
 * 递归方式解决 链表删除问题
 * @author xiaopantx
 * @version 1.0
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
