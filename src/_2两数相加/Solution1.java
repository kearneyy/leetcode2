package _2两数相加;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//原始版本
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        boolean flag = false;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1!=null&&l2!=null)
        {
            int num = flag? l1.val+l2.val+1:l1.val+l2.val;
            if(num>9)
            {
                flag=true;
                ListNode node = new ListNode(num-10);
                temp.next=node;
            }
            else
            {
                flag=false;
                ListNode node = new ListNode(num);
                temp.next=node;
            }
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int num = flag? l1.val+1:l1.val;
            if(num>9)
            {
                flag=true;
                ListNode node = new ListNode(num-10);
                temp.next=node;
            }
            else
            {
                flag=false;
                ListNode node = new ListNode(num);
                temp.next=node;
            }
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int num = flag? l2.val+1:l2.val;
            if(num>9)
            {
                flag=true;
                ListNode node = new ListNode(num-10);
                temp.next=node;
            }
            else
            {
                flag=false;
                ListNode node = new ListNode(num);
                temp.next=node;
            }
            temp=temp.next;
            l2=l2.next;
        }
        if(flag)
        {
            temp.next=new ListNode(1);
        }
        return head.next;
    }
}