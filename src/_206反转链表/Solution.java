package _206反转链表;
//
/**
 * 206. 反转链表
 * 难度
 * 简单
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//自己的解法 利用外部空间 比较弱智

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode myhead = new ListNode(head.val);
        while(head.next!=null)
        {
            ListNode node = new ListNode(head.next.val);
            node.next=myhead;
            myhead=node;
            head=head.next;
        }
        return myhead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        show(node1);
        ListNode mynode = reverseList(node1);
        System.out.println();
        show(mynode);
    }

    public static void show(ListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
}