package _99恢复搜索二叉树;

import java.util.Stack;

//利用堆栈实现
public class Solution2 {
    public static void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, prep = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root=stack.pop();
            if (prep!=null&&prep.val>root.val)
            {
                y=root;
                if(x==null)
                    x=prep;
                else
                {
                    break;
                }
            }
            prep=root;
            root=prep.right;
        }
        int temp = x.val;
        x.val=y.val;
        y.val=temp;
    }


    public static void show(TreeNode root) {
        if (root!=null)
        {
            show(root.left);
            System.out.println(root.val);
            show(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new  TreeNode(1);
        TreeNode node2 = new  TreeNode(3);
        TreeNode node3 = new  TreeNode(2);
        TreeNode node4 = new  TreeNode(4);
//          TreeNode node21 = new  TreeNode(1);
//          TreeNode node22 = new  TreeNode(1);
//          TreeNode node23 = new  TreeNode(2);
        node2.left=node1;
        node2.right=node4;
        node4.left=node3;
//         node21.left=node22;
//         node21.right=node23;
        show(node2);
        recoverTree(node2);
        System.out.println("-----------");
        show(node2);

    }
}
