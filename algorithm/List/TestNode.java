package List;

public class TestNode {
    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        ListNode head = listNode.getNode();
        head.addData(1);
        head.addData(2);
        head.addData(4);
        head.addData(5);
        head.addData(6);
//        head.deleteNode(head,3);
//        head.insertNode(head,10,5);
        head.traverse(head);
        System.out.println("链表长度：" + head.linkListLength(head));
    }

}
