package _111二叉树的最小深度;

import java.util.ArrayList;
import java.util.List;

/**
 * 111二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }

class Solution {
     static List<Integer> list = new ArrayList<Integer>();
    public static int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        find(root,0);
        int min=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<min)
                min=list.get(i);
        }
        return min;
    }

    public static void find(TreeNode root,int depth)
    {
        depth++;
        if(root.left==null&&root.right==null)
        {
            list.add(depth);
            return;
        }
        if(root.left!=null)
        find(root.left,depth);
        if(root.right!=null)
        find(root.right,depth);
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
        System.out.println(minDepth(node1));
    }
}