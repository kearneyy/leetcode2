package _21合并两个有序链表;

/**
 * 递归方法
 */
class Solution2 {
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val>l2.val)
        {
             l2.next = mergeTwoLists2(l1,l2.next);
             return l2;
        }
        else
        {
             l1.next = mergeTwoLists2(l1.next,l2);
             return l1;
        }
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
        ListNode list = mergeTwoLists2(l1, l5);
        for (int i = 0; i < 7; i++) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}

