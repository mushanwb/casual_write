package LeetCode;

import List.ListNode;
import com.sun.xml.internal.ws.util.xml.CDATA;

import java.util.ArrayList;
import java.util.List;

public class No0206 {

//    编写一个函数，检查输入的链表是否是回文的。 
//
//    示例 1：
//
//    输入： 1->2
//    输出： false
//    示例 2：
//
//    输入： 1->2->2->1
//    输出： true

    public static void main(String[] args) {
        int[] datas = {1,2,3,2,1,2};
        ListNode firstNode = new ListNode(datas[0]);
        ListNode.setHead(firstNode);
        ListNode head = ListNode.getHead();
        for (int i = 1;i<datas.length;i++) {
            head.addData(datas[i]);
        }
        System.out.print(isPalindrome(head));
    }

    // 使用 ArrayList 存链表的值,并且使用双指针
    // 执行结果：4ms 43.6 MB   28%
//    public static boolean isPalindrome(ListNode head) {
//        List<Integer> data = new ArrayList<>();
//
//        while (head != null) {
//            data.add(head.data);
//            head = head.next;
//        }
//        if (data.size() == 0) {
//            return true;
//        }
//
//        int i = 0;
//        int j = data.size() - 1;
//        while (true) {
//            if (!data.get(i).equals(data.get(j))) {
//                return false;
//            }
//            if (i == j || (i + 1) == j) {
//                return true;
//            }
//            i++;
//            j--;
//        }
//
//    }

    // 使用快慢指针,慢指针一次走一步,快指针一次走两步,当快指针到链表中间时,慢指针就是链表的中间点
    // 区分偶数和奇数情况
    // 偶数:慢指针走到区分点,快指针的后面还有一个。奇数:快指针走到最后
    // 执行结果:1 ms  42.5 MB  99.93%
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode midNode = findMidNode(head);
        ListNode reverseNode = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = reverseNode;
        while (curr2 != null) {
            if (!curr1.data.equals(curr2.data)) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    // 寻找链表的中点,并返回中点之后的链表
    // 假如链表为：1，2，3，3，2，1 则返回3，3，2，1  如果链表为：1，2，3，2，1 则返回 3，2，1
    private static ListNode findMidNode(ListNode head){
        ListNode fastNode = head;
        ListNode lowNode = head;
        while(fastNode.next != null && fastNode.next.next != null){
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
        }
        return lowNode;
    }

    // 链表反转
    private static ListNode reverseLinked(ListNode head){
        ListNode tempNode = head;
        ListNode reverseNode = null;
        while (tempNode != null) {
            ListNode node = tempNode.next;
            tempNode.next = reverseNode;
            reverseNode = tempNode;
            tempNode = node;
        }
        return reverseNode;
    }


}

