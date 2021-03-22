package _145二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 145. 二叉树的后序遍历
 难度
 中等
 给定一个二叉树，返回它的 后序 遍历。
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

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

/**
 * 迭代实现，用栈
 */
class Solution {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            list.add(0,node.val);
            if(node.left!=null)
                stack.add(node.left);
            if(node.right!=null)
                stack.add(node.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> list = postorderTraversal(node1);
        System.out.println(list);
    }
}