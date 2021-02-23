package List

import (
	"fmt"
	"testing"
)

// 链表定义
type ListNode struct {
	Val    int
	next    *ListNode
}

func TestList(t *testing.T)  {

	// 删除链表
	//head := reversalHead()
	//head1 := deleteNode(head, 3)
	//Shownode(head1)


	// 翻转链表
	//head := reversalHead()
	//head1 := Reversal(head)
	//Shownode(head1)


	// 合并两个链表
	//head, twoHead := mergeHead()
	//tempHead := mergeTwoLists(head, twoHead)
	//Shownode(tempHead)


	// 判断链表是否成环
	head := hasCycleHead()
	t.Log(hasCycle(head))
}

// 链表遍历
func Shownode(p *ListNode) {
	for p != nil {
		fmt.Println(p.Val)
		p = p.next //移动指针
	}
}

// 删除节点
func deleteNode(head *ListNode, val int) *ListNode {
	tempHead := head
	if head.Val == val {
		tempHead = head.next
	} else {
		for head.next != nil {
			if head.next.Val == val {
				head.next = head.next.next
				break
			}
			head = head.next
		}
	}
	return tempHead
}

func reversalHead() *ListNode {
	var head = new(ListNode)
	head.Val = 1
	var node1 = new(ListNode)
	node1.Val = 2
	head.next = node1
	var node2 = new(ListNode)
	node2.Val = 3
	node1.next = node2
	var node3 = new(ListNode)
	node3.Val = 4
	node2.next = node3
	var node4 = new(ListNode)
	node4.Val = 5
	node3.next = node4
	return head
}

// 链表反转
func Reversal(head *ListNode) *ListNode {
	lastHead := new(ListNode)
	lastHead = nil
	for head != nil {
		tempHead := head
		head = head.next
		tempHead.next = lastHead
		lastHead = tempHead
	}
	return lastHead
}

// 添加节点
func addHead(head *ListNode, addHead *ListNode) *ListNode {
	tempHead := head
	if tempHead == nil {
		return addHead
	}
	for tempHead != nil {
		if tempHead.next == nil {
			tempHead.next = addHead
			break
		}
		tempHead = tempHead.next
	}
	return head
}

func mergeHead() (*ListNode, *ListNode) {
	var head = new(ListNode)
	head.Val = 1
	var head1 = new(ListNode)
	head.next = head1
	head1.Val = 2
	var head2 = new(ListNode)
	head1.next = head2
	head2.Val = 4
	var twoHead = new(ListNode)
	twoHead.Val = 1
	var twoHead1 = new(ListNode)
	twoHead.next = twoHead1
	twoHead1.Val = 3
	var twoHead2 = new(ListNode)
	twoHead1.next = twoHead2
	twoHead2.Val = 4
	return head, twoHead
}

// 合并两个有序链表
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	var resultHead *ListNode = nil
	for l1 != nil {
		if l2 == nil {
			resultHead = addHead(resultHead, l1)
			break
		} else {
			var tempHead *ListNode
			if l1.Val <= l2.Val {
				tempHead = l1
				l1 = l1.next
			} else {
				tempHead = l2
				l2 = l2.next
			}
			tempHead.next = nil
			resultHead = addHead(resultHead, tempHead)
		}
	}
	resultHead = addHead(resultHead, l2)
	return resultHead
}

func hasCycleHead() *ListNode {
	var head = new(ListNode)
	head.Val = 1
	var node1 = new(ListNode)
	node1.Val = 2
	head.next = node1
	var node2 = new(ListNode)
	node2.Val = 3
	node1.next = node2
	var node3 = new(ListNode)
	node3.Val = 4
	node2.next = node3
	var node4 = new(ListNode)
	node4.Val = 5
	node3.next = node4
	//node4.next = node2
	return head
}

//判断链表中是否有环
func hasCycle(head *ListNode) bool {
	if head == nil || head.next == nil || head.next.next == nil {
		return false
	}

	slow := head
	quick := head.next

	for quick.next != nil {
		if slow == quick {
			return true
		} else {
			if quick.next.next == nil {
				return false
			}
			slow = slow.next
			quick = quick.next.next
		}
	}

	return false
}