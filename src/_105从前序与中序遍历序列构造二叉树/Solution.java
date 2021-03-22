package _105从前序与中序遍历序列构造二叉树;


import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
     static int index;
     static Map<Integer,Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        index=0;
        return helper(0,inorder.length-1,preorder);
    }

    public static TreeNode helper(int left,int right,int[] preorder)
    {
        if(left>right)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        int midindex = map.get(preorder[index]);
        index++;
        node.left=helper(left,midindex-1,preorder);
        node.right=helper(midindex+1,right,preorder);
        return node;
    }

    public static void main(String[] args) {
       TreeNode node = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node);
    }
}