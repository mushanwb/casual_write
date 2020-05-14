package com.github.hcsp.polymorphism;

class test {
    public static void main(String[] args) {

        Node node = new Node();
        Node head = node.getNode();
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



class Node{
    private static Node head = new Node();

    private Integer data;
    private Node next;


      public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node getNode() {
        return head;
    }

    /**
     * 向链表添加数据
     *
     * @param value 要添加的数据
     */
    public void addData(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        // 找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }


    /**
     * 遍历链表
     *
     * @param head 头节点
     */
    public void traverse(Node head) {

        //临时节点，从首节点开始
        Node temp = head.next;

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
    public void insertNode(Node head, int index, int value) {
        if (index < 1 || index > linkListLength(head) + 1) {
            return;
        }
        //临时节点，从头节点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        //初始化要插入的节点
        Node insertNode = new Node(value);

        while (temp.next != null) {
            //找到上一个节点的位置了
            if (currentPos == (index-1)) {
                //temp表示的是上一个节点

                //将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;

                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;
                return;
            }

            currentPos++;
            temp = temp.next;
        }

    }

    /**获取链表长度
     * @param head 指针
     */
    public int linkListLength(Node head) {
        Node temp = head.next;
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
    public void deleteNode(Node head, int index) {
        if (index < 1 || index > linkListLength(head)) {
            return;
        }

        Node temp = head;

        int currentPos = 0;

        while (temp.next != null) {
            if (currentPos == (index-1)) {

                Node deleteNode = temp.next;

                temp.next = deleteNode.next;

                return;
            }

            currentPos++;
            temp = temp.next;
        }
    }


}
