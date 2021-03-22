package _110平衡二叉树;

/**
 * 110. 平衡二叉树
 * 难度
 * 简单
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else
            return Math.abs(TreeLength(root.left)-TreeLength(root.right))<=1&&isBalanced(root.right)&&isBalanced(root.left);

    }

    public static int TreeLength(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(TreeLength(root.left),TreeLength(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(isBalanced(node1));
    }
}
