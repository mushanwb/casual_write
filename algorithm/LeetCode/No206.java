package LeetCode;

import List.ListNode;

import java.util.Arrays;

public class No206 {

//    反转一个单链表。
//
//    示例:
//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        int[] datas = {1,2,3,4,5};
        ListNode firstNode = new ListNode(datas[0]);
        ListNode.setHead(firstNode);
        ListNode head = ListNode.getHead();
        for (int data:datas) {
            head.addData(data);
        }
        System.out.println(Arrays.toString(ListNode.headToArray(head)));
        ListNode resultHead = reverseList(head);
        System.out.println(Arrays.toString(ListNode.headToArray(resultHead)));
    }

    // 链表反转思路:获取当前的链表节点值,并且引用到临时链表中,
    // 同时将原链表往下移,等于是去掉当前链表的节点
    // 将当前链表节点的指针指向新的链表,在引用给新的链表
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            // 这里 tempNode 只是拿到 head 的地址
            ListNode tempNode = head;
            // 因为 head.next 的地址和 head 的地址不同,
            // 所以要先在这里将 head.next 地址赋值给 head
            head = head.next;
            tempNode.next = newHead;
            newHead = tempNode;

            // 如果是在这里赋值地址,就会有问题
            // 因为这里的 head 其实还是和 tempNode 的地址一样,同一个对象
            // 而在上面 tempNode 的对象已经改变了,tempNode.next = newHead (null)
            // 所以如果在这里赋值的话，head 就始终为 null
//            head = head.next;

        }
        return newHead;
    }





}
