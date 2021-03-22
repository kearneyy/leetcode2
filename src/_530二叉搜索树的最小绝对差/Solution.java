package _530二叉搜索树的最小绝对差;

/**
 *530. 二叉搜索树的最小绝对差
 * 难度
 * 简单
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
class Solution {
     static int min=Integer.MAX_VALUE;
     static int lastnum=-1;
     static int nownum=-1;
    public static int getMinimumDifference(TreeNode root) {
        TreeNode cur = root;
        TreeNode mostright = null;
        while (cur!=null)
        {
            mostright=cur.left;
            if(mostright!=null)
            {
                while (mostright.right!=null&&mostright.right!=cur)
                {
                    mostright=mostright.right;
                }
                if(mostright.right==null)
                {
                    mostright.right=cur;
                    cur=cur.left;
                    continue;
                }
                else{
                    mostright.right=null;
                }
            }
            if(lastnum==-1)
                lastnum=cur.val;
            else
            {
                nownum=cur.val;
                min=Math.min(nownum-lastnum,min);
                lastnum=nownum;
            }
            cur=cur.right;
        }
        return min;
    }


    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(6);
        node13.left = node12;
        node11.right = node13;
        System.out.println( getMinimumDifference(node11));

    }
}