package _103二叉树的锯齿形层序遍历;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int count=0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            if(count%2==0)
            {
                for (int i = 0; i < size; i++) {
                    TreeNode first = deque.pollFirst();
                    list.add(first.val);
                    if(first.left!=null)
                    {
                        deque.add(first.left);
                    }
                    if(first.right!=null)
                    {
                        deque.add(first.right);
                    }
                }
            }
            else
            {
                for (int i = 0; i < size; i++) {
                    TreeNode last = deque.pollLast();
                    list.add(last.val);
                    if(last.right!=null)
                    {
                        deque.addFirst(last.right);
                    }
                    if(last.left!=null)
                    {
                        deque.addFirst(last.left);
                    }
                }
            }
            count++;
            lists.add(list);

        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        System.out.println(zigzagLevelOrder(n1));
    }
}