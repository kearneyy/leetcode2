package _92反转链表II;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
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

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode pre = listNode;
        for (int i = 1; i < left ; i++) {
         pre = pre.next;
        }

        ListNode rightnode = pre;
        for (int i = 0; i < right-left+1; i++) {
            rightnode = rightnode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightnode.next;

        pre.next = null;
        rightnode.next = null;

        reverseLinkedList(leftNode);

        pre.next = rightnode;
        leftNode.next = curr;


        return listNode.next;
    }

    private void reverseLinkedList(ListNode leftNode) {
        ListNode pre = null;
        ListNode curr = leftNode;
        while (curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
    }
}