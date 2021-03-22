package _144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//法二
class Solution2 {
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {//栈不空或者节点不为空
            while (node != null) {//如果节点不为空
                list.add(node.val);//把节点加入list
                stack.push(node);//节点加入stack
                node = node.left;//节点向左下移动
            }
            node = stack.pop();//此时节点为空，node赋值为pop出的数
            node = node.right;//节点向右移动
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new  TreeNode(1);
        TreeNode node2 = new  TreeNode(2);
        TreeNode node3 = new  TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> list = preorderTraversal2(node1);
        System.out.println(list);
    }
}
