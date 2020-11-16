package LeetCode;

import List.ListNode;

public class No141 {

    // 题目和实例连接: https://leetcode-cn.com/problems/linked-list-cycle/

    public static void main(String[] args) {

    }


    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针
        ListNode p = head;
        ListNode q = head;

        while(q.next != null) {
            p = p.next;
            if (q.next.next == null) {
                return false;
            }
            q = q.next.next;
            // 快指针能追上慢指针时，就代表时环形
            if (p == q) {
                return true;
            }
        }

        return false;
    }

}
