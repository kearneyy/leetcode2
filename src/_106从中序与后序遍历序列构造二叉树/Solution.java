package _106从中序与后序遍历序列构造二叉树;


import java.util.HashMap;
import java.util.Map;

class TreeNode {
   int val;
   TreeNode left;
    TreeNode right;
      TreeNode(int x) { val = x; }
 }

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 看题解写的
 */
class Solution {
    static int index;
    static Map<Integer,Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(0,inorder.length-1,postorder);
    }

    public static TreeNode helper(int left,int right,int[] postorder){
        if(left>right)
            return null;
        TreeNode node = new TreeNode(postorder[index]);
        int midindex = map.get(postorder[index]);
        index--;
        node.right=helper(midindex+1,right,postorder);
        node.left=helper(left,midindex-1,postorder);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(node);
    }
}