package _94二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 难度
 * 中等
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */



class TreeNode {
  int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        LDR(root,list);
        return list;
    }

    private static void LDR(TreeNode node,ArrayList<Integer> list){
        if(node.left!=null)
        {
            LDR(node.left,list);
        }
        if(node!=null)
        {
            list.add(node.val);
        }
        if(node.right!=null)
        {
            LDR(node.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right=node2;
        node2.left=node3;
        List<Integer> list = inorderTraversal(node1);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}