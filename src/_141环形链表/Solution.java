package _141环形链表;

/**
 * 141. 环形链表
 * 难度
 * 简单
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */


class ListNode {
 int val;
    ListNode next;
   ListNode(int x) {
         val = x;
        next = null;
    }
 }

 //快慢指针
public class Solution {
    public static boolean hasCycle(ListNode head) {
        ListNode node1=head;//快指针
        ListNode node2=head;//慢指针
        boolean flag=false;
        while(node1!=null&&node1.next!=null&&node2!=null)
        {
            node1=node1.next.next;
            node2=node2.next;
            if(node1==node2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);
//        node1.next=node2;
//        node2.next=node1;
//        node3.next=node4;
//        node4.next=node2;
        System.out.println(hasCycle(node1));
    }
}