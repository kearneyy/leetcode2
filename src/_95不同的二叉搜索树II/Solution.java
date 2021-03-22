package _95不同的二叉搜索树II;


import java.util.LinkedList;
import java.util.List;

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

    public void show(TreeNode node) {
        if(node==null)
        {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val+" ");
        show(node.left);
        show(node.right);
    }

}


/**
 * 95. 不同的二叉搜索树 II
 * 难度
 * 中等
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
class Solution {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> tree = new LinkedList<>();
        if(start>end)
        {
            tree.add(null);
            return tree;
        }

        for (int i = start; i <=end; i++) {
            List<TreeNode> lefttree = generateTrees(start,i-1);
            List<TreeNode> righttree = generateTrees(i+1,end);

            for (TreeNode left : lefttree) {
                for (TreeNode right : righttree) {
                    TreeNode node = new TreeNode(i);
                    node.left=left;
                    node.right=right;
                    tree.add(node);
                }
            }

        }
        return tree;
    }

    public static void main(String[] args) {
        List<TreeNode> tree = generateTrees(3);
        for (TreeNode treeNode : tree) {
            treeNode.show(treeNode);
            System.out.println();
        }
    }
}
