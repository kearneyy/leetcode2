package _234回文链表;



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public static boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid = slow;//中间节点
        ListNode reverseNode = reverse(slow.next);//中间下一个反转，得到反转后的头节点
        ListNode midnext = reverseNode;//midnext指向反转后的头节点
        ListNode second=head;
        boolean flag = true;
        while (midnext!=null)
        {
            if(second.val!=midnext.val)
            {
                flag=false;
                break;
            }
            second=second.next;
            midnext=midnext.next;
        }
        mid.next=reverse(reverseNode);
        return flag;
    }

    public static ListNode reverse(ListNode head)
    {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null)
        {
            ListNode temp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        boolean palindrome = isPalindrome(n1);
        System.out.println(palindrome);
    }

}
