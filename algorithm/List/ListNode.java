package List;

public class ListNode {
    private static ListNode head = new ListNode();

    public Integer data;
    public ListNode next;

    public static ListNode getHead() {
        return head;
    }

    public static void setHead(ListNode head) {
        ListNode.head = head;
    }

    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 将链表转化为数组，方便打印
     *
     * @param head 链表
     * @return 返回数组
     */
    public static int[] headToArray(ListNode head) {
        ListNode temp = head;
        int length = linkListLength(temp);
        int[] headArray = new int[length];
        int i = 0;
        while (head != null) {
            headArray[i] = head.data;
            head = head.next;
            i++;
        }
        return headArray;
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
        ListNode temp = head;

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
        //临时节点
        ListNode temp = head;

        //插入头结点思路：先将头结点值拿出来，创建成新节点
        //将原来的头结点值更改为要插入的节点值
        //将拿出来的头节点插入到第二个节点中
        if (index == 1) {
            int tempData = temp.data;
            temp.data = value;
            ListNode insertListNode = new ListNode(tempData);
            insertListNode.next = temp.next;
            temp.next = insertListNode;
            return;
        }

        //初始化要插入的节点
        ListNode insertListNode = new ListNode(value);

        //记录遍历的当前位置
        int currentPos = 1;

        //从头节点开始
        while (temp != null) {
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
    public static int linkListLength(ListNode head) {
        ListNode temp = head;
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

        if (index == 1) {
            temp.data = temp.next.data;
            temp.next = temp.next.next;
            return;
        }

        int currentPos = 1;

        while (temp != null) {
            if (currentPos == (index-1)) {

                ListNode deleteListNode = temp.next;

                temp.next = deleteListNode.next;

                return;
            }

            currentPos++;
            temp = temp.next;
        }
    }


    /**
     * 链表翻转
     * @param head 头节点
     * @return 翻转后链表
     *
     *  1 -> 4 -> 5 -> 7
     */
    public static ListNode reverseLinked(ListNode head) {
        ListNode endNode = null;

        while (head.next != null ) {
            ListNode tempNode = head;
            head = head.next;
            tempNode.next = endNode;
            endNode = tempNode;
        }

        return endNode;
    }

    /**
     * 判断链表是否成环
     * @param head 头节点
     * @return true or false
     */
    public static boolean annulusNode(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return false;
        }

        // 快慢指针
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast.next != null) {
            slow = slow.next;
            if (fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
