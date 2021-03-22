package _113路径总和II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. 路径总和 II
 * 难度
 * 中等
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//dfs加回溯
class Solution {
    static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null)
            return lists;
        dfs(root,sum,0,lists);
        return lists;
    }

    private static void dfs(TreeNode root, int sum, int total, List<List<Integer>> lists) {
        if(root!=null)
        {
            deque.add(root.val);
            total+=root.val;
            if (root.left==null&&root.right==null)
            {
                if(total==sum)
                {
                    lists.add(new ArrayList<>(deque));
                }
            }
            if(root.left!=null)
            {
                dfs(root.left,sum,total,lists);
            }

            if(root.right!=null)
            {
                dfs(root.right,sum,total,lists);
            }
            total-=root.val;
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node6.left=node9;
        node6.right=node10;

        List<List<Integer>> lists = pathSum(node1, 22);
        System.out.println(lists);
    }
}