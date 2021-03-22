package _21合并两个有序链表;

/**
 * 迭代
 */
class Solution3 {
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode prev = pre;
        while(l1!=null&&l2!=null)
        {
            if(l1.val>l2.val)
            {
                prev.next=l2;
                l2=l2.next;
                prev=prev.next;

            }
            else
            {
                prev.next=l1;
                l1=l1.next;
                prev=prev.next;
            }
        }

        prev.next = l1 ==null? l2:l1;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode list = mergeTwoLists3(l1, l5);
        for (int i = 0; i < 7; i++) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
