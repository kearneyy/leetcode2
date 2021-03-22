package _206反转链表;
//双指针迭代
//https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
//还有一种递归比较难理解
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode temp = cur.next;//这里cur是等于head了，那么temp就不需要创建新的结点
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
