package _114二叉树展开为链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 难度
 * 中等
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * 例如，给定二叉树
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//前序遍历
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prep = list.get(i-1);
            TreeNode curr = list.get(i);
            prep.left=null;
            prep.right=curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
