package _107二叉树的层序遍历II;

import java.util.*;

//改进
class Solution2 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        dfs(0, root, lists);
        Collections.reverse(lists);
        return lists;
    }

    private static void dfs(int level, TreeNode node, List<List<Integer>> lists) {
        if (node != null)
        {
            if (lists.size() == level) {
                lists.add(new ArrayList<>());
            }
            lists.get(level).add(node.val);
            dfs(level+1,node.left,lists);
            dfs(level+1,node.right,lists);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> lists = levelOrderBottom(node1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
