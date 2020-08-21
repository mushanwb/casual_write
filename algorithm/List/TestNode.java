package List;

import java.util.Arrays;

public class TestNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode.setHead(listNode);
        ListNode head = ListNode.getHead();
        head.addData(2);
        head.addData(3);
        head.addData(4);
        head.addData(5);
        head.addData(6);

//        head.deleteNode(head,1);
//        head.insertNode(head,1,10);
//        head.traverse(head);
        System.out.println(Arrays.toString(ListNode.headToArray(head)));
//        System.out.println("链表长度：" + ListNode.linkListLength(head));
    }


}
