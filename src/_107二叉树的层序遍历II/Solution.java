package _107二叉树的层序遍历II;


import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * 难度
 * 简单
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
class TreeNode {
   int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//第一次写，其实没必要map
class Solution {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        if(root==null)
            return lists;
        dfs(0,root,lists,map);
        return lists;
    }

    private static void dfs(int deep,TreeNode node,List<List<Integer>> lists,Map<Integer,List<Integer>> map)
    {
        if(node==null)
            return;
        else
        {
            if(map.containsKey(deep))
            {
                List<Integer> list = map.get(deep);
                list.add(node.val);
            }
            else
            {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                lists.add(0,list);
                map.put(deep,list);
            }
            dfs(deep+1,node.left,lists,map);
            dfs(deep+1,node.right,lists,map);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2= new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        List<List<Integer>> lists= levelOrderBottom(node1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
