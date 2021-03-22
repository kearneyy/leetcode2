package _19删除链表的倒数第N个节点;

import java.util.Deque;
import java.util.LinkedList;

//还可以用栈
//效率比较低 其实跟Solution1有点像 都是把所有数存起来
public class Solution3 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while (temp!=null)
        {
            stack.push(temp);
            temp=temp.next;
        }
        for (int i = 0; i <n; i++) {
            stack.pop();
        }
        ListNode node = stack.pop();
        node.next=node.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode node = removeNthFromEnd(n1, 5);
        System.out.println(node);
    }
}
