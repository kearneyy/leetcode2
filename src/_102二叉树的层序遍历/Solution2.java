package _102二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 队列
 */

class Solution2 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int flag = queue.size();
            for (int i = 0; i < flag; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    temp.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            res.add(temp);
        }
        return res;
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
