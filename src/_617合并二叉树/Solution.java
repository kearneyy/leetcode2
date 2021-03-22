package _617合并二叉树;

/**
 * 617. 合并二叉树
 * 难度
 * 简单
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后
 * 的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */

//自己写的，代码太乱
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode head = new TreeNode(t1.val + t2.val);
        addNewNode(t1.left,t2.left,head,true);
        addNewNode(t1.right,t2.right,head,false);
        return head;
    }

    public static void addNewNode(TreeNode t1, TreeNode t2, TreeNode head, boolean left) {
        if (t1 != null || t2 != null) {
            TreeNode node;
            int flag=0;//初始 flag为1是t2空，flag为2是t1空，flag为3的都不空
            if (t1 == null) {
                node = new TreeNode(t2.val);
                flag=2;
            } else if (t2 == null) {
                node = new TreeNode(t1.val);
                flag=1;
            } else {
                node = new TreeNode(t2.val + t1.val);
                flag=3;
            } 
            if (left) {
                head.left = node; 
                head=head.left;
            }
            else
            {
                head.right = node;
                head=head.right;
            }
            if(flag==1)
            {
                addNewNode(t1.left,t2,head,true);
                addNewNode(t1.right,t2,head,false);
            }
            if(flag==2)
            {
                addNewNode(t1,t2.left,head,true);
                addNewNode(t1,t2.right,head,false);
            }
            if(flag==3)
            {
                addNewNode(t1.left,t2.left,head,true);
                addNewNode(t1.right,t2.right,head,false);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node11 =new TreeNode(1);
        TreeNode node12 =new TreeNode(3);
        TreeNode node13 =new TreeNode(2);
        TreeNode node14 =new TreeNode(5);
        node11.left=node12;
        node12.left=node14;
        node11.right=node13;

        TreeNode node21= new TreeNode(2);
        TreeNode node22= new TreeNode(1);
        TreeNode node23= new TreeNode(3);
        TreeNode node24= new TreeNode(4);
        TreeNode node25= new TreeNode(7);

        node21.left=node22;
        node21.right=node23;
        node22.right=node24;
        node23.right=node25;

        TreeNode node = mergeTrees(node11, node21);
        System.out.println(node);
    }
}