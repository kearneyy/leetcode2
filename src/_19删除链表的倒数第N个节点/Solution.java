package _19删除链表的倒数第N个节点;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 * 难度
 * 中等
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 */

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//一次遍历，把node都存到数组里，时间花销较大
class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)
            return null;
        List<ListNode> listNodeList = new ArrayList<ListNode>();
        ListNode temp = head;
        while(temp!=null)
        {
            listNodeList.add(temp);
            temp=temp.next;
        }
        if(n==listNodeList.size())
            return head.next;
        if(n!=1)
        {
            ListNode listNode1 = listNodeList.get(listNodeList.size() - n - 1);
            ListNode listNode2 = listNodeList.get(listNodeList.size() - n +1);
            listNode1.next=listNode2;
        }
        else
        {
            ListNode listNode1 = listNodeList.get(listNodeList.size() - n - 1);
            listNode1.next=null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next=n2;
//        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
        ListNode node = removeNthFromEnd(n1, 2);
        System.out.println(node);
    }
}