package LeetCode;

public class No141 {

    // 题目和实例连接: https://leetcode-cn.com/problems/linked-list-cycle/

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(node));
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
    public static boolean hasCycle(ListNode head) {

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

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
