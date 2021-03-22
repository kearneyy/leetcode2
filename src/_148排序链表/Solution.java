package _148排序链表;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;

    }
}

//链表用归并排序，先找到中间节点然断开（快慢指针），然后合并两个链表使之有序 参考21和876
//找的中点和传统中点不太一样，这边中点如果只有两个节点，返回第一个，21是返回第二个
class Solution {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode righthead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(righthead);

        return mergeTwoLists(left, right);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null||head.next==null)
            return head;
        ListNode fast = head.next.next, low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode listNode = sortList(n1);
        System.out.println(listNode);
    }
}

