package _86分隔链表;

import java.util.LinkedList;
import java.util.List;

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
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
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode largefirst = large;
        ListNode smallfirst = small;
        while (head!=null)
        {
            int val = head.val;
            if(val<x)
            {
                small.next = head;
                small = small.next;

            }
            else
            {
                large.next = head;
                large = large.next;

            }
            head = head.next;
        }
        large.next=null;
        small.next=largefirst.next;
        return smallfirst.next;
    }

    public static void main(String[] args) {
        ListNode n1 =new ListNode(1);
        ListNode n2 =new ListNode(4);
        ListNode n3 =new ListNode(3);
        ListNode n4 =new ListNode(2);
        ListNode n5 =new ListNode(5);
        ListNode n6 =new ListNode(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        ListNode partition = partition(n1, 3);
        System.out.println(partition);
    }
}