package _144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 难度
 * 中等
 * 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]  
 *    1
 *     \
 *      2
 *     /
 *    3 
 *
 * 输出: [1,2,3]
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


//先打印左子树，再打印右子树，所以先把右边加入，再利用栈的特性
class Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null)
                stack.add(node.right);
            if(node.left!=null)
                stack.add(node.left);
        }
        return list;
    }

    public static void main(String[] args) {
         TreeNode node1 = new  TreeNode(1);
         TreeNode node2 = new  TreeNode(2);
         TreeNode node3 = new  TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> list = preorderTraversal(node1);
        System.out.println(list);
    }
}