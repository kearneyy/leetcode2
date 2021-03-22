package _142环形链表II;

/**
 *142. 环形链表 II
 * 难度
 * 中等
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 */


class ListNode {
    int val;
   ListNode next;
    ListNode(int x) {
       val = x;
        next = null;
   }
}

//双指针+数学
//https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
public class Solution {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode res = null;
        while (fast!=null&&fast.next!=null&&slow.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                res=head;
                break;
            }
        }
        if(res==null)
            return res;
        else
            while (res!=slow)
            {
                res=res.next;
                slow=slow.next;
            }
            return res;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(detectCycle(node1).val);
    }
}