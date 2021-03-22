package _328奇偶链表;

import java.util.List;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 *
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
 class ListNode {
  int val;
   ListNode next;
 ListNode() {}
   ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        ListNode node = head;
        ListNode temp = head.next;
        ListNode node2 = temp;
        while (node.next!=null&&temp.next!=null)
        {
            node.next=node.next.next;
            node=node.next;
            temp.next=node.next;
            temp=temp.next;
        }
        node.next=node2;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
        ListNode listNode = oddEvenList(n1);
        System.out.println(listNode);
    }
}