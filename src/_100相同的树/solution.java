package _100相同的树;

/**
 * 100. 相同的树
 * 难度
 * 简单
 * 426
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
            return (p==null||q==null)?p == null && q == null:p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(1);
        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(1);
        TreeNode node23 = new TreeNode(2);
        node11.left=node12;
        node11.right=node13;
        node21.left=node22;
        node21.right=node23;
        System.out.println(isSameTree(node11,node21));

    }
}