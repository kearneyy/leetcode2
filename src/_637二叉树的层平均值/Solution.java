package _637二叉树的层平均值;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
     TreeNode left;
   TreeNode right;
     TreeNode(int x) { val = x; }
 }

/**
 * 637. 二叉树的层平均值
 * 难度
 * 简单
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
class Solution {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root==null)
            return list;
        List<Integer> deeplist = new ArrayList<>();
        dfs(list,root,0,deeplist);
        return list;
    }

    private static void dfs(List<Double> list, TreeNode root, int deep, List<Integer> deeplist)
    {
        if(root==null)
            return;
        if(list.size()>deep)
        {
            Double getNum = list.get(deep);
            Integer num = deeplist.get(deep);
            list.set(deep,(getNum*num+root.val)/(num+1));
            deeplist.set(deep,num+1);
        }
        else
        {
            list.add((double) root.val);
            deeplist.add(1);
        }
        dfs(list,root.left,deep+1,deeplist);
        dfs(list,root.right,deep+1,deeplist);
    }

    public static void main(String[] args) {
        TreeNode node1 =new TreeNode(3);
        TreeNode node2=new TreeNode(1);
        TreeNode node3 =new TreeNode(5);
        TreeNode node4 =new TreeNode(0);
        TreeNode node5 =new TreeNode(2);
        TreeNode node6 =new TreeNode(4);
        TreeNode node7 =new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        List<Double> list = averageOfLevels(node1);
        for (Double aDouble : list) {
            System.out.println(aDouble);
        }
    }
}