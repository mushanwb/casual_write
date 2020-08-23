package LeetCode;

import List.ListNode;

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
        int[] datas = {1,2,3,2,1};
        ListNode firstNode = new ListNode(datas[0]);
        ListNode.setHead(firstNode);
        ListNode head = ListNode.getHead();
        for (int i = 1;i<datas.length;i++) {
            head.addData(datas[i]);
        }
        System.out.print(isPalindrome(head));
    }

    //做法低效
    public static boolean isPalindrome(ListNode head) {
        List<Integer> data = new ArrayList<>();

        while (head != null) {
            data.add(head.data);
            head = head.next;
        }
        if (data.size() == 0) {
            return true;
        }

        int i = 0;
        int j = data.size() - 1;
        while (true) {
            if (!data.get(i).equals(data.get(j))) {
                return false;
            }
            if (i == j || (i + 1) == j) {
                return true;
            }
            i++;
            j--;
        }

    }

}

