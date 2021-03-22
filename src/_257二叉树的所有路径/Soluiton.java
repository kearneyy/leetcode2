package _257二叉树的所有路径;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 257. 二叉树的所有路径
 * 难度
 * 简单

 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
class Solution {
    static List<String> list = new ArrayList<String>();
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root==null)
            return list;
        StringBuilder sb = new StringBuilder();
        find(root,sb);
        return list;
    }

    private static void find(TreeNode node,StringBuilder sb)
    {
        StringBuilder sbtemp = new StringBuilder(sb);
        sbtemp.append(node.val);
        if(node.left==null&&node.right==null)
        {
            list.add(sbtemp.toString());
            return;
        }
        else
        {
            sbtemp.append("->");
            if(node.left!=null)
            {
                find(node.left, sbtemp);
            }

            if(node.right!=null)
            {
                find(node.right, sbtemp);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left=node2;
        node2.right=node4;
        node1.right=node3;
        List<String> list = binaryTreePaths(node1);
        for (String s : list) {
            System.out.println(s);
        }
    }
}