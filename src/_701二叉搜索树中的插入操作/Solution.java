package _701二叉搜索树中的插入操作;

/**
 *701. 二叉搜索树中的插入操作
 * 难度
 * 中等
 *
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 */

class TreeNode {
  int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
         this.right = right;
     }
 }

 //两次递归 第一次从左往右找到右边界
//第二次从右往左找到左边界
//自己写的dfs
//执行结果：
//通过
//显示详情
//
//执行用时：
//0 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//39.5 MB
//, 在所有 Java 提交中击败了
//48.92%
//的用户
class Solution {
    private static TreeNode rightNode;
    private static TreeNode leftNode;
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);//建立节点
        if(root==null)
            return node;//如果根为空直接返回
        dfsFirst(root,val);//第一次遍历找到右边界节点
        if(rightNode==null){//如果右边界节点为空
            TreeNode temp = root;
            while (temp.right!=null)
            {
                temp=temp.right;
            }
            temp.right=node;
            return root;//则直接在最右边加入节点返回
        }
        dfsSecond(rightNode.left,val);//第二次遍历找到左边界节点
        if(leftNode==null)
            rightNode.left=node;//如果左边界节点为空，则没有左子树，直接在left加入节点node
        else
        {
            leftNode.right=node;//在左边界的右子树加入node
        }
        return root;//返回
    }

    private static void dfsFirst(TreeNode root,int val)//从左往右遍历
    {
        if(root==null)
            return;
        if(rightNode==null)
        {
            dfsFirst(root.left,val);
            if(val<root.val&&rightNode==null)
            {
                rightNode = root;
                return;
            }
            dfsFirst(root.right,val);
        }

    }

    private static void dfsSecond(TreeNode root,int val)//从右往左遍历
    {
        if(root==null)
            return;
        if(leftNode==null)
        {
            dfsSecond(root.right,val);
            if(val>root.val&&leftNode==null)
            {
                leftNode = root;
                return;
            }
            dfsSecond(root.left,val);
        }
    }

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node20 = new TreeNode(20);
        TreeNode node30 = new TreeNode(30);
        TreeNode node40 = new TreeNode(40);
        TreeNode node50 = new TreeNode(50);
        TreeNode node60 = new TreeNode(60);
        TreeNode node70 = new TreeNode(70);
        TreeNode node31 = new TreeNode(31);
        node20.left=node10;
        node20.right=node30;
        node40.left=node20;
        node40.right=node60;
        node60.left=node50;
        node60.right=node70;
        node30.right=node31;
        TreeNode node = insertIntoBST(node40,32);
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n7 = new TreeNode(7);
//        n2.left=n1;
//        n2.right=n3;
//        n4.left=n2;
//        n4.right=n7;
//        TreeNode node = insertIntoBST(n4, 5);
        System.out.println(node);
    }
}