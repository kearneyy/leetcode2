package _24两两交换链表中的节点;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * 难度
 * 中等
 *
 * 687
 *
 *
 *
 *
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
class ListNode {
   int val;
   ListNode next;
  ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode myhead = first;
        ListNode second = head;
        ListNode nextNode = second;
        while (nextNode!=null)
        {
            if(second.next==null)
                break;
            first.next=second.next;
            nextNode =second.next.next;
            first.next.next=second;
            second.next=nextNode;
            first=second;
            second=second.next;
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
//        n5.next=n6;
        ListNode node = swapPairs(n1);
        System.out.println(node);

    }
}