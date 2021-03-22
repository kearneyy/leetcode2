package _94二叉树的中序遍历;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 迭代,递归快一些
 */
public class Solution2 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root!=null||!stk.isEmpty())//直到空栈且root为空退出
        {
            while (root!=null)//一直往左遍历并且压栈
            {
                stk.push(root);
                root=root.left;
            }
            //当左边没了 弹栈，并把节点加入list，让root指向右边的分支
            TreeNode pop = stk.pop();
            list.add(pop.val);
            root=pop.right;
        }
        return list;
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
