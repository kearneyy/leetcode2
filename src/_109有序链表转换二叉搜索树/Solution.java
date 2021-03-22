package _109有序链表转换二叉搜索树;

/**
 * 109. 有序链表转换二叉搜索树
 * 难度
 * 中等
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */



 class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

 class TreeNode {
    int val;
   TreeNode left;
    TreeNode right;
    TreeNode() {}
   TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    public TreeNode buildTree(ListNode left,ListNode right)
    {
        if(left==right)
            return null;
        ListNode mid = findMid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left=buildTree(left,mid);
        root.right=buildTree(mid.next,right);
        return root;
    }



    public ListNode findMid(ListNode left,ListNode right)
    {
        ListNode slow = left;
        ListNode fast = left;
        while(fast!=right&&fast.next!=right)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}