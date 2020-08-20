package List;

public class ListNode {
    private static ListNode head = new ListNode();

    private Integer data;
    private ListNode next;


    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode getNode() {
        return head;
    }

    /**
     * 向链表添加数据
     *
     * @param value 要添加的数据
     */
    public void addData(int value) {
        ListNode newListNode = new ListNode(value);
        ListNode temp = head;
        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newListNode;
    }


    /**
     * 遍历链表
     *
     * @param head 头节点
     */
    public void traverse(ListNode head) {

        //临时节点，从首节点开始
        ListNode temp = head.next;

        while (temp != null) {

            if (temp.data != null) {
                System.out.println("链表值：" + temp.data);
            }

            //继续下一个
            temp = temp.next;
        }
    }

    /**插入节点
     * @param head 指针
     * @param index 插入位置
     * @param value 插入值
     */
    public void insertNode(ListNode head, int index, int value) {
        if (index < 1 || index > linkListLength(head) + 1) {
            return;
        }
        //临时节点，从头节点开始
        ListNode temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        //初始化要插入的节点
        ListNode insertListNode = new ListNode(value);

        while (temp.next != null) {
            //找到上一个节点的位置了
            if (currentPos == (index-1)) {
                //temp表示的是上一个节点

                //将原本由上一个节点的指向交由插入的节点来指向
                insertListNode.next = temp.next;

                //将上一个节点的指针域指向要插入的节点
                temp.next = insertListNode;
                return;
            }

            currentPos++;
            temp = temp.next;
        }

    }

    /**获取链表长度
     * @param head 指针
     */
    public int linkListLength(ListNode head) {
        ListNode temp = head.next;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    /**
     * @param head 头节点
     * @param index 删除的位置
     */
    public void deleteNode(ListNode head, int index) {
        if (index < 1 || index > linkListLength(head)) {
            return;
        }

        ListNode temp = head;

        int currentPos = 0;

        while (temp.next != null) {
            if (currentPos == (index-1)) {

                ListNode deleteListNode = temp.next;

                temp.next = deleteListNode.next;

                return;
            }

            currentPos++;
            temp = temp.next;
        }
    }

}
