package _144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            //如果cur的左子树为空直接打印
            else {
               list.add(cur.val);
            }
            cur = cur.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new  TreeNode(1);
        TreeNode node2 = new  TreeNode(2);
        TreeNode node3 = new  TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> list = preorderTraversal3(node1);
        System.out.println(list);
    }
}
