package _21合并两个有序链表;


class Solution {
    /**
     21. 合并两个有序链表
     难度
     简单
     将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     自己写的
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode list = null;
            int flag = l1.val >= l2.val ? 1 : 0;
            if (flag == 0) {
                list = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                list = new ListNode(l2.val);
                l2 = l2.next;
            }
            ListNode temp = list;
            while (l1 != null && l2 != null) {
                ListNode listnext = null;
                if (l1.val > l2.val) {
                    listnext = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    listnext = new ListNode(l1.val);
                    l1 = l1.next;
                }
                temp.next = listnext;
                temp = temp.next;
            }
            if (l1 == null) {
                temp.next = l2;
            }
            if (l2 == null) {
                temp.next = l1;
            }
            return list;
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
        ListNode list = mergeTwoLists(l1, l5);
        for (int i = 0; i < 7; i++) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}