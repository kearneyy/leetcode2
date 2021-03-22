package _99恢复搜索二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 难度
 * 困难
 *
 * 271
 *
 *
 *
 *
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * 示例 1:
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
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

 //利用中序遍历，先中序遍历一次记录所有的结点存入一个List里，然后再遍历节点找出两个数xy，最后交换
class Solution {
    public static void recoverTree(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(root,list);
        int[] twonum = findtonum(list);
        recover(root,2,twonum[0],twonum[1]);
    }



     public static void inorder(TreeNode root,LinkedList<Integer> list)
    {
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }


    //这个之前写的有问题
     public static int[] findtonum(List<Integer> nums) {
         int n =nums.size();
         int x=-1,y=-1;
         for (int i = 0; i < n - 1; i++) {
             if(nums.get(i+1)<nums.get(i))
             {
                 y=nums.get(i+1);
                 if(x==-1)
                     x=nums.get(i);
                 else
                 {
                     break;
                 }
             }
         }
         return new int[]{x,y};
     }


     public static void recover(TreeNode root, int count, int x, int y) {
        if (root!=null)
        {
            if(root.val==x||root.val==y)
            {
                root.val=root.val==x?y:x;
                if(--count==0)
                    return;
            }
            recover(root.left,count,x,y);
            recover(root.right,count,x,y);
        }
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