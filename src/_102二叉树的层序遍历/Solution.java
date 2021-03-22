package _102二叉树的层序遍历;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**102. 二叉树的层序遍历
 难度
 中等
 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * DFS
 */

class Solution {
    static List<List<Integer>> list = new ArrayList<List<Integer>>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        myfun(root, 0);
        return list;
    }

    public static void myfun(TreeNode node, int level) {
        if (node != null) {
            if (list.size() == level) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);
            myfun(node.left, level + 1);
            myfun(node.right, level + 1);
        }
    }


    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(17);
        node0.left = node1;
        node0.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(levelOrder(node0));
    }
}
